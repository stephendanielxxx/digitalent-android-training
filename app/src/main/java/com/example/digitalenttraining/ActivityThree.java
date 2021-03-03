package com.example.digitalenttraining;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digitalenttraining.model.UserModel;

public class ActivityThree extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);


        String isi = getIntent().getStringExtra("isiTextView");

        UserModel userModel = getIntent().getParcelableExtra("parcelable");

        textView.setText(userModel.getName());
    }
}