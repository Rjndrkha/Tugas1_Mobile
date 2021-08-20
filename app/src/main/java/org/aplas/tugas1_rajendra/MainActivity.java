package org.aplas.tugas1_rajendra;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.aplas.tugas1_rajendra.login_register.HalamanEmpat;
import org.aplas.tugas1_rajendra.maps.MapsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this,  HalamanEmpat.class);
                startActivity(i);
                finish();
            }
        }, 5000);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(this , "Rajendra Rakha Arya Prabaswara", Toast.LENGTH_LONG).show();
    }

}