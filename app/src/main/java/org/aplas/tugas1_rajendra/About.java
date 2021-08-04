package org.aplas.tugas1_rajendra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(this , "\u2667 WELCOME TO MY APP \u2667", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu,menu);

        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.clkabout){
            startActivity(new Intent(this,About.class));
        }else if(item.getItemId()==R.id.clkout){
            startActivity(new Intent(this,HalamanEmpat.class));

            Toast.makeText(this, "Logout Success", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    public void ClickBack(View view){
        Intent i = new Intent(About.this, Berhasil.class);
        startActivity(i);
    }

}