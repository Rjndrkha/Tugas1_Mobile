package org.aplas.tugas1_rajendra;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.aplas.tugas1_rajendra.calculator.CalculatorApp;
import org.aplas.tugas1_rajendra.login_register.HalamanEmpat;
import org.aplas.tugas1_rajendra.recycle_data.ItemAdapter;
import org.aplas.tugas1_rajendra.recycle_data.ItemModel;
import org.aplas.tugas1_rajendra.recycle_data.MyItem;

import java.util.ArrayList;

public class HalamanUtama extends AppCompatActivity {

    ActionBar action;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<ItemModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_utama);

        action = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.Recycle);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        data = new ArrayList<>();
        for (int i = 0; i < MyItem.Headline.length; i++) {
            data.add(new ItemModel(
                    MyItem.Headline[i],
                    MyItem.Caption[0],
                    MyItem.Gambar[i]));
        }
        adapter=new ItemAdapter(this,data);
        recyclerView.setAdapter(adapter);
    }




    @Override
    public boolean onSupportNavigateUp() {
       onBackPressed();
       return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this,Berhasil.class));
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
            startActivity(new Intent(this, HalamanEmpat.class));

            Toast.makeText(this, "Logout Success", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    public void Calculator(View view){

        startActivity(new Intent(this, CalculatorApp.class));
    }



}