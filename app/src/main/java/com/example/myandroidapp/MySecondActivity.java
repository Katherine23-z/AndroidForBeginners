package com.example.myandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;

public class MySecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_second);

        findViewById(R.id.button_return).setOnClickListener(v -> finish());
        findViewById(R.id.button_night).setOnClickListener(v -> {
            setTheme(R.style.Theme_MyAndroidApp_Dark);
            recreate();
        });
        findViewById(R.id.button_no_night).setOnClickListener(v -> {
            setTheme(R.style.Theme_MyAndroidApp_Light);
            recreate();
        });
    }
}