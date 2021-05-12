package com.example.myandroidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private static final String KEY = "NUMBER_FIELD";
    private static final String KEY_RESULT = "RESULT_FIELD";

    boolean plus;
    boolean minus;
    boolean multiply;
    boolean split;
    boolean percent;

    protected TextView resultTextView;
    protected TextView textView;
    private MaterialButton buttonPlus;
    private MaterialButton buttonMinus;
    private MaterialButton buttonMultiply;
    private MaterialButton buttonSplit;
    private MaterialButton buttonPercent;

    private double valueOne;
    private double valueTwo;
    private double result;

    private String numberField;
    private String resultField;

    Counter counter;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        resultTextView = findViewById(R.id.resultTextView);
        counter = new Counter(textView, resultTextView);
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
        findViewById(R.id.button_dot).setOnClickListener(v -> textView.setText(String.format("%s.", (textView.getText()))));

        findViewById(R.id.button_settings).setOnClickListener(v -> startActivity(new Intent(this, MySecondActivity.class)));

        buttonPlus = findViewById(R.id.button_plus);
        buttonPlus.setOnClickListener(v -> {
            operandOnClick(buttonPlus);
            plus = true;
        });

        buttonMinus = findViewById(R.id.button_minus);
        buttonMinus.setOnClickListener(v -> {
            operandOnClick(buttonMinus);
            minus = true;
        });

        buttonMultiply = findViewById(R.id.button_multiply);
        buttonMultiply.setOnClickListener(v -> {
            operandOnClick(buttonMultiply);
            multiply = true;
        });

        buttonSplit = findViewById(R.id.button_split);
        buttonSplit.setOnClickListener(v -> {
           operandOnClick(buttonSplit);
            split = true;
        });

        buttonPercent = findViewById(R.id.button_percent);
        buttonPercent.setOnClickListener(v -> {
            operandOnClick(buttonPercent);
            percent = true;
        });

        findViewById(R.id.button_clear).setOnClickListener(v -> textView.setText(null));

        findViewById(R.id.button_equal).setOnClickListener(v -> {
            calculate();
            resultTextView.setText(resultTextView.getText().toString() + (valueTwo) + "=" + result);
        });

    }
    public void operandOnClick(MaterialButton button) {
        if (!TextUtils.isEmpty(textView.getText().toString())) {
            valueOne = Double.parseDouble(textView.getText().toString());
            resultTextView.setText(String.format("%s%s", valueOne, button.getText().toString()));
            textView.setText(null);
        } else {
            resultTextView.setText("Введите число");
        }
    }

    private void calculate() {
        valueTwo = Double.parseDouble(textView.getText().toString());
        textView.setText(null);
        if (plus) {
            result = valueOne + valueTwo;
            plus = false;
        } else if (minus) {
            result = valueOne - valueTwo;
            minus = false;
        } else if (multiply) {
            result = valueOne * valueTwo;
            multiply = false;
        } else if (split) {
            result = valueOne / valueTwo;
            split = false;
        } else if (percent) {
            result = valueOne * valueTwo / 100;
            percent = false;
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        numberField = savedInstanceState.getString(KEY);
        resultField = savedInstanceState.getString(KEY_RESULT);
        textView.setText(numberField);
        resultTextView.setText(resultField);
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY, textView.getText().toString());
        outState.putString(KEY_RESULT, resultTextView.getText().toString());
    }

}