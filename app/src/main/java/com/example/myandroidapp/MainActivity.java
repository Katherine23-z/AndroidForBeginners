package com.example.myandroidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

import javax.crypto.spec.OAEPParameterSpec;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    boolean plus;
    boolean minus;
    boolean multiply;
    boolean split;
    boolean percent;

    private TextView textView;
    private EditText editText;

    private double valueOne;
    private double valueTwo;
    private double result;

    String numberField;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String instanceState;

        if (savedInstanceState == null) {
            instanceState = "Первый запуск";
        } else {
            instanceState = "Повторный запуск";
        }

        Log.d(TAG, "onCreate " + instanceState);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        findViewById(R.id.button1).setOnClickListener(v -> editText.setText(String.format("%s1", editText.getText())));
        findViewById(R.id.button2).setOnClickListener(v -> editText.setText(String.format("%s2", editText.getText())));
        findViewById(R.id.button3).setOnClickListener(v -> editText.setText(String.format("%s3", editText.getText())));
        findViewById(R.id.button4).setOnClickListener(v -> editText.setText(String.format("%s4", editText.getText())));
        findViewById(R.id.button5).setOnClickListener(v -> editText.setText(String.format("%s5", editText.getText())));
        findViewById(R.id.button6).setOnClickListener(v -> editText.setText(String.format("%s6", editText.getText())));
        findViewById(R.id.button7).setOnClickListener(v -> editText.setText(String.format("%s7", editText.getText())));
        findViewById(R.id.button8).setOnClickListener(v -> editText.setText(String.format("%s8", editText.getText())));
        findViewById(R.id.button9).setOnClickListener(v -> editText.setText(String.format("%s9", editText.getText())));
        findViewById(R.id.button0).setOnClickListener(v -> editText.setText(String.format("%s0", editText.getText())));
        findViewById(R.id.button_dot).setOnClickListener(v -> editText.setText(String.format("%s.", (editText.getText()))));
        findViewById(R.id.button_plus).setOnClickListener(v -> {
            valueOne = Double.parseDouble(editText.getText().toString());
            plus = true;
            textView.setText(valueOne + "+");
            editText.setText(null);
        });

        findViewById(R.id.button_minus).setOnClickListener(v -> {
            valueOne = Double.parseDouble(editText.getText().toString());
            minus = true;
            textView.setText(valueOne + "-");
            editText.setText(null);
        });

        findViewById(R.id.button_multiply).setOnClickListener(v -> {
            valueOne = Double.parseDouble(editText.getText().toString());
            multiply = true;
            textView.setText(valueOne + "*");
            editText.setText(null);
        });

        findViewById(R.id.button_split).setOnClickListener(v -> {
            valueOne = Double.parseDouble(editText.getText().toString());
            split = true;
            textView.setText(valueOne + "/");
            editText.setText(null);
        });

        findViewById(R.id.button_percent).setOnClickListener(v -> {
            valueOne = Double.parseDouble(editText.getText().toString());
            percent = true;
            textView.setText(valueOne + "%");
            editText.setText(null);
        });

        findViewById(R.id.button_clear).setOnClickListener(v -> editText.setText(null));

        findViewById(R.id.button_equal).setOnClickListener(v -> {
            calculate();
            textView.setText(textView.getText().toString() + valueTwo + "=" + result);
        });

    }

    private void calculate() {
        valueTwo = Double.parseDouble(editText.getText().toString());
        editText.setText(null);
        if (plus){
            result = valueOne + valueTwo;
            plus = false;
        }else if (minus){
            result = valueOne - valueTwo;
            minus = false;
        }else if (multiply){
            result = valueOne * valueTwo;
            multiply = false;
        }else if (split){
            result = valueOne/valueTwo;
            split = false;
        }else if (percent){
            result = valueOne * valueTwo / 100;
            percent = false;
        }
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