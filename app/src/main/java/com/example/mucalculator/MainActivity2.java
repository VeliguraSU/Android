package com.example.mucalculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    Switch switch1;
    Button button_back;
    private static final int AppThemeDefoult = 0;
    private static final String PREFERENCE_NAME = "name";
    private static final String THEME_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(loadAppTheme());
        setContentView(R.layout.activity_main2);
        findViewById(R.id.button_back).setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);

            startActivity(intent);
        });


        switch1 = findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (isChecked == true) {
                saveAppTheme(0);
                recreate();
            } else {
                saveAppTheme(1);
                recreate();
            }

        });
    }


    private int codStyleToStyleID(int code) {
        if (code == 0) {
            return R.style.MyTheme;
        } else {
            return R.style.MyDARCTheme;
        }

    }


    private void saveAppTheme(int code) {
        getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE)
                .edit()
                .putInt(THEME_NAME, code)
                .apply();

    }

    private int loadAppTheme() {
        int code = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE)
                .getInt(THEME_NAME, AppThemeDefoult);
        return codStyleToStyleID(code);
    }
}


