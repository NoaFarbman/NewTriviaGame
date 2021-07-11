package com.example.new_android_project;

import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import static com.example.new_android_project.ResponseAnswers.*;

public class TriviaQuestion {
    private String question;
    private int answer;

    public TriviaQuestion(JSONObject json_question_parmeters) {
        try {
            this.question = json_question_parmeters.getString("question");
            this.answer = json_question_parmeters.getInt("answer");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public String checkAnswer(String answer) {
        if (String.valueOf(this.answer).equals(answer)){
            return GOTIT;
        }else
            return TRYAGAIN;
    }

    public String getQuestion() {
        return this.question;
    }



}


