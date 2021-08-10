package org.aplas.tugas1_rajendra;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class HalamanEmpat extends AppCompatActivity {



        private TextView txWelcome;
        private EditText editTextPassword;
        private EditText editTextUsername;

        private final String TAG =Register.class.getName();
        public static final String Key_Register="Key_Register";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_empat);


        //Password
        editTextPassword=findViewById(R.id.psw);
        //username
        editTextUsername=findViewById(R.id.unm);


    }

    public void Login(View view) {
        String username=editTextUsername.getText().toString();
        String email="Null";


        //validasi input password kosong
        if(TextUtils.isEmpty(editTextPassword.getText().toString().trim())){
            Toast.makeText(view.getContext(), "Password Kosong!", Toast.LENGTH_LONG).show();
        }
        //validasi input Username kosong
        else if(TextUtils.isEmpty(editTextUsername.getText().toString().trim())){
            Toast.makeText(view.getContext(), "Username Kosong!", Toast.LENGTH_LONG).show();
        }
        else {
            Intent i = new Intent(HalamanEmpat.this, Berhasil.class);
            i.putExtra(Key_Register,new String[]{username,email});
            startActivity(i);
            Toast.makeText(this, "Log-in Success", Toast.LENGTH_SHORT).show();
        }

    }

    public void Register(View view) {
        Intent i = new Intent(HalamanEmpat.this, Register.class);
        startActivity(i);
    }




}