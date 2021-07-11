package com.example.new_android_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class TriviaMain extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.textView1);
        Button bt1 = findViewById(R.id.button1);
        String name1 = bt1.getText().toString();
        Button bt2 = findViewById(R.id.button2);
        String name2 = bt2.getText().toString();
        Button bt3 = findViewById(R.id.button3);
        String name3 = bt3.getText().toString();
        Button bt4 = findViewById(R.id.button4);
        String name4 = bt4.getText().toString();
        HttpRequestHandler httpRequestHandler = new HttpRequestHandler();
        Thread requestThread = new Thread(httpRequestHandler);
        requestThread.start();
        try {
            requestThread.join();
        }
            catch (Exception e) {
            new Throwable(e);
    }
        TriviaQuestion triviaQuestion = new TriviaQuestion(httpRequestHandler.getJsonResponse());
        tv.setText(triviaQuestion.getQuestion());
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText(triviaQuestion.checkAnswer(name1));
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText(triviaQuestion.checkAnswer(name2));
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText(triviaQuestion.checkAnswer(name3));
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText(triviaQuestion.checkAnswer(name4));
            }
        });



                }

}

