package com.example.myandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MySecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_second);

        findViewById(R.id.button_return).setOnClickListener(v -> finish());
    }
}