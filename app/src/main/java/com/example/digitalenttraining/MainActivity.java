package com.example.digitalenttraining;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.digitalenttraining.api.APIActivity;
import com.example.digitalenttraining.glide.GlideActivity;
import com.example.digitalenttraining.list.ListViewActivity;
import com.example.digitalenttraining.maps.MapsActivity;
import com.example.digitalenttraining.model.UserModel;

public class MainActivity extends AppCompatActivity {

    private Button btn_pindah;
    private Button btn_day_2;
    private Button btn_day_2_api;
    private Button btn_day_3_glide;
    private Button btn_maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("TAG", "Hello World");

        btn_pindah = findViewById(R.id.btn_pindah);
        btn_day_2 = findViewById(R.id.btn_day_2);
        btn_day_2_api = findViewById(R.id.btn_day_2_api);
        btn_day_3_glide = findViewById(R.id.btn_day_3_glide);
        btn_maps = findViewById(R.id.btn_maps);

        UserModel userModel = new UserModel("Try", "Tangerang", 21);

        btn_pindah.setOnClickListener(v -> {
            Intent activityTwo = new Intent(getApplicationContext(), ActivityTwo.class);
            activityTwo.putExtra("isiTextView", "Ini isi text view");
            activityTwo.putExtra("parcelable", userModel);
            startActivity(activityTwo);
        });

        btn_day_2.setOnClickListener(v->{
            Intent day2 = new Intent(getApplicationContext(), ListViewActivity.class);
            startActivity(day2);
        });

        btn_day_2_api.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day2_api = new Intent(getApplicationContext(), APIActivity.class);
                startActivity(day2_api);
            }
        });

        btn_day_3_glide.setOnClickListener(v->{
            Intent glide = new Intent(getApplicationContext(), GlideActivity.class);
            startActivity(glide);
        });

        btn_maps.setOnClickListener(v->{
            Intent maps = new Intent(getApplicationContext(), MapsActivity.class);
            startActivity(maps);
        });
    }
}