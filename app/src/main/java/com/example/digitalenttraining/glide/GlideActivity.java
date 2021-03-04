package com.example.digitalenttraining.glide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.digitalenttraining.R;

public class GlideActivity extends AppCompatActivity {

    private Button btn_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);

        btn_image = findViewById(R.id.btn_image);

        btn_image.setOnClickListener(v->{
            Intent showImage = new Intent(getApplicationContext(), ShowImageActivity.class);
            startActivity(showImage);
        });
    }
}