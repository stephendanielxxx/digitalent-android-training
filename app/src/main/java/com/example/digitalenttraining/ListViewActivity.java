package com.example.digitalenttraining;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ListViewActivity extends AppCompatActivity {

    private Button btn_list_view;
    private Button btn_recycler_view;
    private Button btn_horizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        btn_list_view = findViewById(R.id.btn_list_view);
        btn_recycler_view = findViewById(R.id.btn_recycler_view);
        btn_horizontal = findViewById(R.id.btn_horizontal);

        btn_list_view.setOnClickListener(v->{
            Intent listView = new Intent(getApplicationContext(), TrainingListViewActivity.class);
            startActivity(listView);
        });

        btn_recycler_view.setOnClickListener(v->{
            Intent recyclerView = new Intent(getApplicationContext(), RecyclerViewActivity.class);
            startActivity(recyclerView);
        });

        btn_horizontal.setOnClickListener(v->{
            Intent horizontal = new Intent(getApplicationContext(), HorizontalListActivity.class);
            startActivity(horizontal);
        });
    }
}