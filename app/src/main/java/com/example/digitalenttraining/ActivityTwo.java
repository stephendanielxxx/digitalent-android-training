package com.example.digitalenttraining;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityTwo extends AppCompatActivity {

    private TextView textView, tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        textView = findViewById(R.id.tvAddressUser);
        tvName = findViewById(R.id.tvName);

        String isi = getIntent().getStringExtra("isiTextView");

        UserModel userModel = getIntent().getParcelableExtra("parcelable");

        textView.setText(userModel.getName());
    }
}