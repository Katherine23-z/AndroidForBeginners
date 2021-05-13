package com.example.myandroidapp;

import android.text.TextUtils;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.io.Serializable;

public class Counter implements Serializable {

    private TextView text;
    private TextView result;


    public Counter(TextView text, TextView result) {
        this.text = text;
        this.result = result;
     }

    public String getText() {
        return text.getText().toString();
    }

    public String getResult() {
        return result.getText().toString();
    }




}
