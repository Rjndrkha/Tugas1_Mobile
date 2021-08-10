package org.aplas.tugas1_rajendra;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    private final String TAG =Register.class.getName();
    public static final String Key_Register="Key_Register";

    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Binding edt_txt_email ke variabel editTextEmail
        editTextEmail = findViewById(R.id.eml);
        //Password
        editTextPassword=findViewById(R.id.psw);
        //username
        editTextUsername=findViewById(R.id.unm);


    }
    public void Register(View view) {

        String username=editTextUsername.getText().toString();
        String email=editTextEmail.getText().toString();

        // Validasi input email kosong
        if(TextUtils.isEmpty(editTextEmail.getText().toString().trim())){
            Toast.makeText(view.getContext(), "Email Kosong!", Toast.LENGTH_LONG).show();
        }
        // Validasi inputan tipe email
        else if(!isValidEmail(editTextEmail.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Email tidak valid!", Toast.LENGTH_LONG).show();
        }
        //validasi input password kosong
        else if(TextUtils.isEmpty(editTextPassword.getText().toString().trim())){
            Toast.makeText(view.getContext(), "Password Kosong!", Toast.LENGTH_LONG).show();
        }
        //validasi input Username kosong
        else if(TextUtils.isEmpty(editTextUsername.getText().toString().trim())){
            Toast.makeText(view.getContext(), "Username Kosong!", Toast.LENGTH_LONG).show();
        }
        else {
            Intent i = new Intent(Register.this, Berhasil.class);
            i.putExtra(Key_Register,new String[]{username,email});
            startActivity(i);
            Toast.makeText(this, "Register Success", Toast.LENGTH_SHORT).show();
        }
    }

    public void Login(View view){
        Intent i = new Intent(Register.this, HalamanEmpat.class);
        startActivity(i);
    }
    public static boolean isValidEmail(CharSequence email) {
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }


}