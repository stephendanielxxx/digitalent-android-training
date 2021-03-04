package com.example.digitalenttraining.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.digitalenttraining.R;

public class CreateUserActivity extends AppCompatActivity {
    Button btnCreateUser;
    EditText etIdUser, etNameUser;
    DataHelper dataHelper;
    String id, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        btnCreateUser = findViewById(R.id.btnCreateUser);
        etIdUser = findViewById(R.id.etIdUser);
        etNameUser = findViewById(R.id.etNameUser);

        id = etIdUser.getText().toString();
        name = etNameUser.getText().toString();

        btnCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dataHelper.getWritableDatabase();
                db.execSQL("insert into user(id,name) values('"+id+"','"+name+"')");
                Toast.makeText(CreateUserActivity.this, "Data berhasil ditambahkan.",
                        Toast.LENGTH_SHORT).show();
                MainSqliteActivity.main.refreshDataList();
                finish();
            }
        });

    }
}