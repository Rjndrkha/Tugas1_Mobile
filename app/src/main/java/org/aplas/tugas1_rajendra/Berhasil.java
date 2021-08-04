package org.aplas.tugas1_rajendra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Berhasil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berhasil);

        //create a date string.
        String date_n = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date());
        //get hold of textview.
        TextView date  = (TextView) findViewById(R.id.dateText);
        //set it as current date.
        date.setText("Today,"+date_n);
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

    public void Logout(View view){
        Intent i = new Intent(Berhasil.this, HalamanEmpat.class);
        startActivity(i);

        Toast.makeText(this, "Logout Success", Toast.LENGTH_SHORT).show();
    }




}