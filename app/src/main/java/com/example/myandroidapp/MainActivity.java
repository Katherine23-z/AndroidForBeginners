package com.example.myandroidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TextView textView;
    String numberField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String instanceState;

        if(savedInstanceState == null){
            instanceState = "Первый запуск";
        }else{
            instanceState = "Повторный запуск";
        }

        Log.d(TAG, "onCreate " + instanceState );

        textView = findViewById(R.id.editText);
        findViewById(R.id.button1).setOnClickListener(v -> textView.setText(String.format("%s1", textView.getText())));
        findViewById(R.id.button2).setOnClickListener(v -> textView.setText(String.format("%s2", textView.getText())));
        findViewById(R.id.button3).setOnClickListener(v -> textView.setText(String.format("%s3", textView.getText())));
        findViewById(R.id.button4).setOnClickListener(v -> textView.setText(String.format("%s4", textView.getText())));
        findViewById(R.id.button5).setOnClickListener(v -> textView.setText(String.format("%s5", textView.getText())));
        findViewById(R.id.button6).setOnClickListener(v -> textView.setText(String.format("%s6", textView.getText())));
        findViewById(R.id.button7).setOnClickListener(v -> textView.setText(String.format("%s7", textView.getText())));
        findViewById(R.id.button8).setOnClickListener(v -> textView.setText(String.format("%s8", textView.getText())));
        findViewById(R.id.button9).setOnClickListener(v -> textView.setText(String.format("%s9", textView.getText())));
        findViewById(R.id.button0).setOnClickListener(v -> textView.setText(String.format("%s0", textView.getText())));
        findViewById(R.id.button_plus).setOnClickListener(v -> textView.setText(String.format("%s+", textView.getText())));
        findViewById(R.id.button_minus).setOnClickListener(v -> textView.setText(String.format("%s-", textView.getText())));
        findViewById(R.id.button_multiply).setOnClickListener(v -> textView.setText(String.format("%s*", textView.getText())));
        findViewById(R.id.button_split).setOnClickListener(v -> textView.setText(String.format("%s/", textView.getText())));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState");
        numberField = savedInstanceState.getString("NUMBER_FIELD");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
        outState.putString("NUMBER_FIELD", String.valueOf(textView));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }


}