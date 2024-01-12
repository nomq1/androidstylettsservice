package com.google.android.ttsengine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://your.api.base.url/") // Replace with your API's base URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create an instance of your API service
        TtsApiService apiService = retrofit.create(TtsApiService.class);

        // Now you can use apiService to make network requests
        // For example: apiService.getAvailableVoices()...



//        setContentView(R.layout.activity_main);
    }
}