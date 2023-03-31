package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

        Intent i = getIntent();
        String user_name = i.getStringExtra("name");

        Toast.makeText(this, "Username: " + user_name, Toast.LENGTH_SHORT).show();
    }
}