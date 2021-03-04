package com.example.digitalenttraining.glide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.digitalenttraining.R;

public class ShowImageActivity extends AppCompatActivity {

    private ImageView iv_image;
    private ImageView iv_placeholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);

        iv_image = findViewById(R.id.iv_image);
        iv_placeholder = findViewById(R.id.iv_placeholder);

        String url = "https://raw.githubusercontent.com/DevTides/countries/master/arg.png";
        String italy = "https://raw.githubusercontent.com/DevTides/countries/master/ita.png";

        ImageUtil.loadImage(iv_image, url);

        ImageUtil.loadImage(iv_placeholder, italy, R.mipmap.ic_launcher_round);

    }
}