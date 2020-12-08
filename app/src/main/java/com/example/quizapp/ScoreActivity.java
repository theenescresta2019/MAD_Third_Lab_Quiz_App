package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Intent intent = getIntent();
        int score=intent.getIntExtra("Score",0);
        String msg=intent.getStringExtra("Message");
        TextView scoreValue = findViewById(R.id.tvScoreDisplay);
        TextView message=findViewById(R.id.tvMessage);
        scoreValue.setText(""+score);
        message.setText(msg);

    }
}