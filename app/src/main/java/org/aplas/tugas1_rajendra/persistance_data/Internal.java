package org.aplas.tugas1_rajendra.persistance_data;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import android.os.Environment;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.aplas.tugas1_rajendra.About;
import org.aplas.tugas1_rajendra.Berhasil;
import org.aplas.tugas1_rajendra.HalamanUtama;
import org.aplas.tugas1_rajendra.R;
import org.aplas.tugas1_rajendra.login_register.HalamanEmpat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Internal extends AppCompatActivity implements View.OnClickListener{


    public static final String FILENAME ="namafile.txt";
        Button buatFile, ubahFile, bacaFile, deleteFile;
        TextView textBaca;
        ActionBar action;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_internal);
            buatFile = findViewById(R.id.buttonBuatFile);
            ubahFile = findViewById(R.id.buttonUbahFile);
            bacaFile = findViewById(R.id.buttonBacaFile);
            deleteFile = findViewById(R.id.buttonHapusFile);
            textBaca = findViewById(R.id.textBaca);
            buatFile.setOnClickListener(this);
            ubahFile.setOnClickListener(this);
            bacaFile.setOnClickListener(this);
            deleteFile.setOnClickListener(this);

            action = getSupportActionBar();
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        void buatFile() {
            String isiFile ="Coba Isi Data File Text";
            File file = new File(getFilesDir(), FILENAME);
            FileOutputStream outputStream = null;
            try {
                file.createNewFile();
                outputStream = new FileOutputStream(file, true);
                outputStream.write(isiFile.getBytes());
                outputStream.flush();
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        void ubahFile() {
            String ubah ="Update Isi Data File Text";
            File file = new File(getFilesDir(), FILENAME);
            FileOutputStream outputStream = null;
            try {
                file.createNewFile();
                outputStream = new FileOutputStream(file, false);
                outputStream.write(ubah.getBytes());
                outputStream.flush();
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        void bacaFile() {
            File sdcard = getFilesDir();
            File file = new File(sdcard, FILENAME);
            if(file.exists()) {
                StringBuilder text = new StringBuilder();
                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String line = br.readLine();
                    while (line != null) {
                        text.append(line);
                        line = br.readLine();
                    }
                    br.close();
                } catch (IOException e) {
                    System.out.println("Error"+ e.getMessage());
                }
                textBaca.setText(text.toString());
            }
        }
        void hapusFile() {
            File file = new File(getFilesDir(), FILENAME);
            if (file.exists()) {
                file.delete();
            }
        }
        @Override
        public void onClick(View v) {
            jalankanPerintah(v.getId());
        }
        public void jalankanPerintah(int id) {
            switch (id) {
                case R.id.buttonBuatFile:
                    buatFile();
                    break;
                case R.id.buttonBacaFile:
                    bacaFile();
                    break;
                case R.id.buttonUbahFile:
                    ubahFile();
                    break;
                case R.id.buttonHapusFile:
                    hapusFile();
                    break;
            }
        }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, Berhasil.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu,menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.clkabout){
            startActivity(new Intent(this, About.class));
        }else if(item.getItemId()==R.id.clkout){
            startActivity(new Intent(this, HalamanEmpat.class));

            Toast.makeText(this, "Logout Success", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.clkhome){
            startActivity(new Intent(this, HalamanUtama.class));
        }
        return true;
    }

    }