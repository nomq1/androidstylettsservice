package com.google.android.ttsengine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        startService(new Intent(this, MyTtsService.class));
//        Intent serviceIntent = new Intent(this, MyTtsService.class);
//        bindService(serviceIntent, myServiceConnection, Context.BIND_AUTO_CREATE);
//        finish();
//        setContentView(R.layout.activity_main);
    }
}