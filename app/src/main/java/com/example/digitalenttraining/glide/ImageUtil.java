package com.example.digitalenttraining.glide;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.digitalenttraining.R;

public class ImageUtil {

    public static void loadImage(ImageView imageView, String url){
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }

    public static void loadImage(ImageView imageView, String url, int placeholder){
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(placeholder);

        Glide.with(imageView.getContext())
                .setDefaultRequestOptions(requestOptions)
                .load(url)
                .into(imageView);
    }
}
