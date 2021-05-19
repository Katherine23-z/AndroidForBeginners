package com.example.myandroidapp;

import android.text.TextUtils;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.io.Serializable;

public class Counter implements Serializable {

    private String text;
    private String result;


    public Counter(String  text, String result) {
        this.text = text;
        this.result = result;
     }

    public String getText() {
        return text;
    }

    public String getResult() {
        return result;
    }
}
