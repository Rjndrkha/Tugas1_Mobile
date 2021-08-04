package org.aplas.tugas1_rajendra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class HalamanEmpat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_empat);
    }

    public void Login(View view) {
        Intent i = new Intent(HalamanEmpat.this, Berhasil.class);
        startActivity(i);

        //AMBIL DATA USERNAME

    }

    public void Register(View view) {
        Intent i = new Intent(HalamanEmpat.this, Register.class);
        startActivity(i);
    }




}