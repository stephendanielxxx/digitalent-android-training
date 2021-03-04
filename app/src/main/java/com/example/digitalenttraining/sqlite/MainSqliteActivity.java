package com.example.digitalenttraining.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.digitalenttraining.R;

public class MainSqliteActivity extends AppCompatActivity {
    Button btnInsertData;
    public static MainSqliteActivity main;
    DataHelper db;
    ListView lvData;
    protected Cursor cursor;
    String[] tmpData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sqlite);

        btnInsertData = findViewById(R.id.btnInsertData);
        lvData = findViewById(R.id.lvData);

        main = this;
        db = new DataHelper(this);

        refreshDataList();

        btnInsertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainSqliteActivity.this, CreateUserActivity.class);
                startActivity(intent);
            }
        });
    }

    public void refreshDataList() {
        SQLiteDatabase data = db.getReadableDatabase();

        cursor = data.rawQuery("SELECT * FROM user", null);
        tmpData = new String[cursor.getCount()];

        cursor.moveToFirst();
        for(int cc = 0; cc < cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            tmpData[cc] = cursor.getString(1).toString();
        }

        lvData.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tmpData));
        lvData.setSelected(true);

        ((ArrayAdapter) lvData.getAdapter()).notifyDataSetChanged();

    }
}