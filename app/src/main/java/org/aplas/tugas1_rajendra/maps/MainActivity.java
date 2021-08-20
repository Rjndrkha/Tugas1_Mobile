package org.aplas.tugas1_rajendra.maps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import org.aplas.tugas1_rajendra.R;
import org.aplas.tugas1_rajendra.calculator.CalculatorApp;
import org.aplas.tugas1_rajendra.calculator.MainCalculator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(i);
                finish();
            }
        }, 4000);
    }
}