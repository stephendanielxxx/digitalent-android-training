package com.example.digitalenttraining.list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.digitalenttraining.R;

public class TrainingListViewActivity extends AppCompatActivity {

    private ListView lv_countries;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_list_view);

        lv_countries = findViewById(R.id.lv_countries);

        String[] countries = {"Argentina", "Brazil", "Canada", "Denmark", "El Salvador", "France", "Germany", "Honduras", "Indonesia", "Japan", "Kamboja",
            "Lebanon", "Malaysia", "Nigeria", "Oman", "Pakistan", "Qatar", "Russia", "Sweden", "Turkey", "Uruguay", "Vietnam", "Wales", "Yaman", "Zimbabwe"};

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, countries);

        lv_countries.setAdapter(adapter);

    }
}