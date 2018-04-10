package com.example.android.quizapp;

import android.content.Intent;
import android.icu.util.TimeUnit;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.checked;

public class DisplayQuizActivity extends AppCompatActivity {

    int totalScore = 0;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_quiz);
        if(savedInstanceState == null){
            startTicking();
        }

        textView = (TextView) findViewById(R.id.timer);
        Intent intent = getIntent();
        startTicking();
    }

    public void submitQuiz(View view) {
        RadioButton questionOneOption = (RadioButton) findViewById(R.id.Q1_CorrectOption);
        if (questionOneOption.isChecked()) {
            totalScore += 10;
        }
        CheckBox questionNineOptionOne = (CheckBox) findViewById(R.id.Q2_CorrectOption1);
        CheckBox questionNineOptionTwo = (CheckBox) findViewById(R.id.Q2_CorrectOption2);
        if (questionNineOptionOne.isChecked()){totalScore += 5;}
        if (questionNineOptionTwo.isChecked()){totalScore += 5;}

        RadioButton questionThreeOption = (RadioButton) findViewById(R.id.Q3_CorrectOption);
        if (questionThreeOption.isChecked()) {
            totalScore += 10;
        }
        EditText editText = (EditText) findViewById(R.id.type_your_answer);
        String answer = editText.getText().toString();
        if (answer.matches("1991") ){totalScore += 10;
        }
        RadioButton questionFiveOption = (RadioButton) findViewById(R.id.Q5_CorrectOption);
        if (questionFiveOption.isChecked()) {
            totalScore += 10;
        }
        RadioButton questionSixOption = (RadioButton) findViewById(R.id.Q6_CorrectOption);
        if (questionSixOption.isChecked()) {
            totalScore += 10;
        }
        RadioButton questionFourOption = (RadioButton) findViewById(R.id.Q4_CorrectOption);
        if (questionFourOption.isChecked()) {
            totalScore += 10;
        }
        RadioButton questionEightOption = (RadioButton) findViewById(R.id.Q8_CorrectOption);
        if (questionEightOption.isChecked()) {
            totalScore += 10;
        }
        RadioButton questionNineOption = (RadioButton) findViewById(R.id.Q9_CorrectOption);
        if (questionNineOption.isChecked()) {
            totalScore += 10;
        }
        RadioButton questionTenOption = (RadioButton) findViewById(R.id.Q10_CorrectOption);
        if (questionTenOption.isChecked()) {
            totalScore += 10;
        }

        Toast.makeText(this, "Your score is: " + ((totalScore * 100) / 100) + "%" + " Thanks You!", Toast.LENGTH_LONG).show();
    }

    public void startTicking() {
        new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                textView.setText("Time Remain (Sec): " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                textView.setText("Time Up! Thanks You!");
            }
        }.start();
    }
}


