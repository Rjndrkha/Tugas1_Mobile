package org.aplas.tugas1_rajendra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void Register(View view){
        Intent i = new Intent(Register.this, Berhasil.class);
        startActivity(i);
    }
    public void Login(View view){
        Intent i = new Intent(Register.this, HalamanEmpat.class);
        startActivity(i);
    }

}