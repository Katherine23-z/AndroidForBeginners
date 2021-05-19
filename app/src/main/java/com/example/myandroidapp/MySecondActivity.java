package com.example.myandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class MySecondActivity extends AppCompatActivity {
    private static final String NameSharedPreference = "THEME_COLOUR";
    private static final String AppTheme = "APP THEME";
    private static final int MyAndroidAppCodeStyle = 0;
    private static final int MyAndroidAppLightCodeStyle = 1;
    private static final int MyAndroidAppDarkCodeStyle = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(MyAndroidAppLightCodeStyle));
        setContentView(R.layout.activity_my_second);

        initThemeChooser();

        findViewById(R.id.buttonReturn).setOnClickListener(v -> finish());
    }

    private void initThemeChooser() {
        initRadioButton(findViewById(R.id.radioButtonDefault), MyAndroidAppCodeStyle);
        initRadioButton(findViewById(R.id.radioButtonLight), MyAndroidAppLightCodeStyle);
        initRadioButton(findViewById(R.id.radioButtonDark), MyAndroidAppDarkCodeStyle);
        RadioGroup rg = findViewById(R.id.radioButtons);
        ((MaterialRadioButton)rg.getChildAt(getCodeStyle(MyAndroidAppLightCodeStyle))).setChecked (true);
    }

    private void initRadioButton(View button, final int codeStyle) {
        button.setOnClickListener(v -> {
            setAppTheme(codeStyle);
            recreate();
        });
    }

    private int getAppTheme(int codeStyle) {
        return codeStyleToStyleId(getCodeStyle(codeStyle));
    }

    private int codeStyleToStyleId(int codeStyle) {
        switch (codeStyle) {
            case MyAndroidAppLightCodeStyle:
                return R.style.MyAndroidAppLightTheme;
            case MyAndroidAppDarkCodeStyle:
                return R.style.MyAndroidAppDarkTheme;
            case MyAndroidAppCodeStyle:
            default:
                return R.style.MyAndroidAppTheme;
        }
    }

    private int getCodeStyle(int codeStyle) {
        SharedPreferences sharedPreferences = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        return sharedPreferences.getInt(AppTheme, codeStyle);
    }

    private void setAppTheme(int codeStyle) {
        SharedPreferences sharedPreferences = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(AppTheme, codeStyle);
        editor.apply();
    }

}