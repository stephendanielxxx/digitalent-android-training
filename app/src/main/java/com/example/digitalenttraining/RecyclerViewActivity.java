package com.example.digitalenttraining;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView rv_countries;
    private CountryAdapter countryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        rv_countries = findViewById(R.id.rv_countries);

        rv_countries.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        String[] countries = {"Argentina", "Brazil", "Canada", "Denmark", "El Salvador", "France", "Germany", "Honduras", "Indonesia", "Japan", "Kamboja",
                "Lebanon", "Malaysia", "Nigeria", "Oman", "Pakistan", "Qatar", "Russia", "Sweden", "Turkey", "Uruguay", "Vietnam", "Wales", "Yaman", "Zimbabwe"};

        countryAdapter = new CountryAdapter(countries);

        rv_countries.setAdapter(countryAdapter);
    }
}