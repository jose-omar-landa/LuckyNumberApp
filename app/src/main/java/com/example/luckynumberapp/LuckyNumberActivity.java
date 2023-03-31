package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LuckyNumberActivity extends AppCompatActivity {

    TextView welcomeTxt, luckyNumberText;
    Button shareBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number);

        welcomeTxt = findViewById(R.id.textView2);
        luckyNumberText = findViewById(R.id.luckyNumberText);
        shareBtn = findViewById(R.id.shareNumberButton);

        //Username data
        Intent i = getIntent();
        String user_name = i.getStringExtra("name");
        Toast.makeText(this, "Username: " + user_name, Toast.LENGTH_SHORT).show();

        //Random number generator
        int random_number = generateRandomNum();
        luckyNumberText.setText(""+random_number);

        //Shares data when share button clicked
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(user_name, random_number);
            }
        });
    }

    public int generateRandomNum() {
        Random random = new Random();
        int upperLimit = 1000;
        int generatedNumber = random.nextInt(upperLimit);
        return generatedNumber;
    }

    public void shareData(String username, int randomNum){
        //Implicit Intents
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        String number = String.valueOf(randomNum);

        i.putExtra(Intent.EXTRA_SUBJECT, username + " has a lucky number!");
        i.putExtra(Intent.EXTRA_TEXT, "Your friend " + username + "'s lucky number is " + number + "!");

        startActivity(Intent.createChooser(i, "Choose A Platform"));
    }

}