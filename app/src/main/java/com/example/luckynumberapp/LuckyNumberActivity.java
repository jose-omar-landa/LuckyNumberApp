package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
    }

    public int generateRandomNum() {
        Random random = new Random();
        int upperLimit = 1000;
        int generatedNumber = random.nextInt(upperLimit);
        return generatedNumber;
    }

}