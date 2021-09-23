package org.aplas.tugas1_rajendra.contact;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.aplas.tugas1_rajendra.R;
import org.aplas.tugas1_rajendra.helper.DbHelper;


public class AddEditActivity extends AppCompatActivity {
    EditText txtId, txtName, txtAddress,txtNumber;
    Button btnSubmit, btnCancel;
    DbHelper SQLite = new DbHelper(this);
    String id, name, address,number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtId = findViewById(R.id.txt_id);
        txtName = findViewById(R.id.txt_name);
        txtAddress = findViewById(R.id.txt_address);
        txtNumber = findViewById(R.id.txt_number);
        btnSubmit = findViewById(R.id.btn_submit);
        btnCancel = findViewById(R.id.btn_cancel);

        id = getIntent().getStringExtra(MainContact.TAG_ID);
        name = getIntent().getStringExtra(MainContact.TAG_NAME);
        address = getIntent().getStringExtra(MainContact.TAG_ADDRESS);
        number = getIntent().getStringExtra(MainContact.TAG_NUMBER);

        if (id == null || id.equals("")) {
            setTitle("Add Data");
        } else {
            setTitle("Edit Data");
            txtId.setText(id);
            txtName.setText(name);
            txtAddress.setText(address);
            txtNumber.setText(number);
        }
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtId.getText().toString().equals("")) {
                    save();
                } else {
                    edit();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blank();
                finish();
            }
        });
    }

    private void blank() {
        txtName.requestFocus();
        txtId.setText(null);
        txtName.setText(null);
        txtAddress.setText(null);
        txtNumber.setText(null);
    }

    private void edit() {
        if (String.valueOf(txtName.getText()).equals("") ||
                String.valueOf(txtAddress.getText()).equals("") ||
                String.valueOf(txtNumber.getText()).equals(""))
        {
            Toast.makeText(this, "Please input name or address or number...", Toast.LENGTH_SHORT).show();

        } else {
            SQLite.update(Integer.parseInt(txtId.getText().toString().trim()), txtName.getText().toString().trim(),
                    txtAddress.getText().toString().trim(),txtNumber.getText().toString().trim());
            blank();
            finish();
        }
    }

    private void save() {
        if (String.valueOf(txtName.getText()).equals("") ||
                String.valueOf(txtAddress.getText()).equals("") ||
                String.valueOf(txtNumber.getText()).equals("")){
            Toast.makeText(this, "Please input name or address or number...", Toast.LENGTH_SHORT).show();

        } else {
            SQLite.insert(txtName.getText().toString().trim(), txtAddress.getText().toString().trim(),
                    txtNumber.getText().toString().trim());
            blank();
            finish();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                blank();
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}