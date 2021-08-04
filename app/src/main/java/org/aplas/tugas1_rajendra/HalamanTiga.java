package org.aplas.tugas1_rajendra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HalamanTiga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_tiga);
    }

    public void ClickNext(View view){
        Intent i = new Intent(HalamanTiga.this, HalamanEmpat.class);
        startActivity(i);
    }
}