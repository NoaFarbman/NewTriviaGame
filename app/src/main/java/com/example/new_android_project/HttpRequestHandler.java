package com.example.new_android_project;

import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class  HttpRequestHandler implements Runnable {
    private JSONObject json_string;
    @Override
    public void run() {
        try {

            URL url = new URL("http://10.0.0.2:5000/");
            OkHttpClient client = new OkHttpClient();
            Request request1 = new Request.Builder()
                    .url(url)
                    .build();
            Call call = client.newCall(request1);
            Response response = call.execute();
            JSONObject jsonObject = new JSONObject(response.body().string());
            this.json_string = jsonObject;

        } catch (Exception e) {
            new Throwable(e);
        }

    }
    public JSONObject getJsonResponse() {
            return this.json_string;
    }
}