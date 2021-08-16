package org.aplas.tugas1_rajendra.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import org.aplas.tugas1_rajendra.R;

public class MainCalculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calculator);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainCalculator.this, CalculatorApp.class);
                startActivity(i);
                finish();
            }
        }, 4000);
    }
}