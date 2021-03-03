package com.example.digitalenttraining;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class HorizontalListActivity extends AppCompatActivity implements HorizontalCountryAdapter.CountryCallback {

    private RecyclerView rv_countries;
    private HorizontalCountryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_list);

        rv_countries = findViewById(R.id.rv_countries);

//        rv_countries.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false));

        rv_countries.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));

        String[] countries = {"Argentina", "Brazil", "Canada", "Denmark", "El Salvador", "France", "Germany", "Honduras", "Indonesia", "Japan", "Kamboja",
                "Lebanon", "Malaysia", "Nigeria", "Oman", "Pakistan", "Qatar", "Russia", "Sweden", "Turkey", "Uruguay", "Vietnam", "Wales", "Yaman", "Zimbabwe"};

        adapter = new HorizontalCountryAdapter(countries, this);

        rv_countries.setAdapter(adapter);

    }

    @Override
    public void onCountrySelected(String country) {
        Toast.makeText(getApplicationContext(), "Country = "+country, Toast.LENGTH_SHORT).show();
        Log.i("Country", "Country = "+country);
    }
}