package com.example.lessononeinjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int TIME_TO_PLAY = 10000;
    public static final int COUNT_DOWN_INTERVAL = 1000;
    int clicks = 0;
        TextView counterTextView;
        TextView timerTextView;
        Button resetButton;
        Button clickCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer_layout);

        counterTextView = findViewById(R.id.counterTextView);
         clickCounter = findViewById(R.id.clickCounter);
        resetButton = findViewById(R.id.resetButton);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });
        timerTextView = findViewById(R.id.timerTextView);
        StartTimer();

        timerTextView.setText("10");
        counterTextView.setText("0");
        clickCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClicked();

            }

        });



    }

    private void StartTimer() {
        CountDownTimer countDownTimer = new CountDownTimer(TIME_TO_PLAY,COUNT_DOWN_INTERVAL) {
            @Override
            public void onTick(long millisUntilFinish ) {
                timerTextView.setText("" + millisUntilFinish/1000);
            }

            @Override
            public void onFinish() {
                clickCounter.setEnabled(false);
            }
        };
        countDownTimer.start();
    }

    private void resetGame() {
        clicks = 0;
        clickCounter.setEnabled(true);
        StartTimer();
        counterTextView.setText(Integer.toString(clicks));
    }

    private void buttonClicked() {
        clicks++;
        counterTextView.setText(Integer.toString(clicks));

    }



    }





