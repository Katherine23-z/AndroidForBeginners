package com.example.myandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MySecondActivity extends AppCompatActivity {

    public static final int RESULT_DARK = 2;
    public static final int RESULT_LIGHT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_second);

        Button dark = findViewById(R.id.button_dark);
        dark.setOnClickListener(v -> {
            Intent intentResult = new Intent();
            setResult(RESULT_DARK, intentResult);
            finish();
        }
    );

        Button light = findViewById(R.id.button_light);
        light.setOnClickListener(v -> {
            Intent intentResult = new Intent();
            setResult(RESULT_LIGHT, intentResult);
            finish();

        });
    }
}