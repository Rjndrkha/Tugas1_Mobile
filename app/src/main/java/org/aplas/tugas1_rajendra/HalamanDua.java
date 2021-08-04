package org.aplas.tugas1_rajendra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HalamanDua extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_dua);
    }

    public void ClickNext(View view) {
        Intent i = new Intent(HalamanDua.this, HalamanTiga.class);
        startActivity(i);
    }
}