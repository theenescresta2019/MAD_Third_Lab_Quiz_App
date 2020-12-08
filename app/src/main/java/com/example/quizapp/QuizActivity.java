package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class QuizActivity extends AppCompatActivity {

    private RadioGroup firstQuestion;
    private RadioGroup secondQuestion;
    private EditText thirdQuestion;
    private CheckBox fourthAnswer1;
    private CheckBox fourthAnswer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Button submitButton = findViewById(R.id.btnSubmit);
        firstQuestion = findViewById(R.id.rgFirstQuestion);
        secondQuestion = findViewById(R.id.rgSecondQuestion);
        thirdQuestion = findViewById(R.id.txtThirdAnswer);
        fourthAnswer1 = findViewById(R.id.cbFourthA);
        fourthAnswer2 = findViewById(R.id.cbFourthB);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int score = 0;
                if (firstQuestion.getCheckedRadioButtonId() == R.id.rbFirstA) {
                    score += 10;
                }
                if (secondQuestion.getCheckedRadioButtonId() == R.id.rbSecondD) {
                    score += 10;
                }
                String thirdAnswer = thirdQuestion.getText().toString();
                if (thirdAnswer.equalsIgnoreCase("Tuesday")) {
                    score += 10;
                }

                if (fourthAnswer1.isChecked() && fourthAnswer2.isChecked()) {
                    score += 10;
                } else if (fourthAnswer1.isChecked()) {
                    score += 5;
                } else if (fourthAnswer2.isChecked()) {
                    score += 5;
                }
                String message ;
                if (score == 40) {
                    message = "Congratulation! You have answered all the answers correctly.";
                } else if (score >= 30) {
                    message = "Well Done! You just missed a answer. Please try again.";
                } else if (score > 20) {
                    message = "Good! You seem to be confused. Please try again.";
                } else {
                    message = "Sorry! You need to improve a lot in IQ. Please try again.";
                }


                Intent intent = new Intent(QuizActivity.this, ScoreActivity.class);
                intent.putExtra("Score", score);
                intent.putExtra("Message", message);
                startActivity(intent);
            }
        });
    }
}