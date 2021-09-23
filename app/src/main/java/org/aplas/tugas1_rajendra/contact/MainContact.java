package org.aplas.tugas1_rajendra.contact;

        import android.content.DialogInterface;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ListView;
        import android.widget.Toast;

        import androidx.appcompat.app.ActionBar;
        import androidx.appcompat.app.AlertDialog;
        import androidx.appcompat.app.AppCompatActivity;

        import com.google.android.material.floatingactionbutton.FloatingActionButton;

        import org.aplas.tugas1_rajendra.About;
        import org.aplas.tugas1_rajendra.Berhasil;
        import org.aplas.tugas1_rajendra.HalamanUtama;
        import org.aplas.tugas1_rajendra.R;
        import org.aplas.tugas1_rajendra.adapter.Adapter;
        import org.aplas.tugas1_rajendra.helper.DbHelper;
        import org.aplas.tugas1_rajendra.login_register.HalamanEmpat;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;

public class MainContact extends AppCompatActivity {

    ListView listView;
    AlertDialog.Builder builder;
    List<Data> dataList = new ArrayList<>();
    Adapter adapter;
    DbHelper SQLite = new DbHelper(this);
    ActionBar action;


    public static final String TAG_ID = "id";
    public static final String TAG_NAME = "name";
    public static final String TAG_ADDRESS = "address";
    public static final String TAG_NUMBER = "number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_contact);

        action = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Tambah SQLite
        SQLite = new DbHelper(getApplicationContext());

        listView = findViewById(R.id.list_view);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainContact.this, AddEditActivity.class));
            }
        });
        adapter = new Adapter(this, dataList);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final String idx = dataList.get(i).getId();
                final String name = dataList.get(i).getName();
                final String address = dataList.get(i).getAddress();
                final String number = dataList.get(i).getNumber();

                final CharSequence[] dialogitem = {"Edit", "Delete"};
                builder = new AlertDialog.Builder(MainContact.this);
                builder.setCancelable(true);
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i) {
                            case 0:
                                Intent intent = new Intent(MainContact.this, AddEditActivity.class);
                                intent.putExtra(TAG_ID, idx);
                                intent.putExtra(TAG_NAME, name);
                                intent.putExtra(TAG_ADDRESS, address);
                                intent.putExtra(TAG_NUMBER, number);
                                startActivity(intent);
                                break;
                            case 1:
                                SQLite.delete(Integer.parseInt(idx));
                                dataList.clear();
                                getAllData();
                                break;
                        }
                    }
                }).show();
                return false;
            }
        });
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

    private void getAllData() {
        ArrayList<HashMap<String, String>> row = SQLite.getAllData();

        for (int i = 0; i < row.size(); i++) {
            String id = row.get(i).get(TAG_ID);
            String name = row.get(i).get(TAG_NAME);
            String address = row.get(i).get(TAG_ADDRESS);
            String number = row.get(i).get(TAG_NUMBER);

            Data data = new Data();

            data.setId(id);
            data.setName(name);
            data.setAddress(address);
            data.setNumber(number);

            dataList.add(data);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        dataList.clear();
        getAllData();
    }
}