package com.example.duofrencholingo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.net.URL;
import java.util.Random;

public class ImageStore {
    private String imageUrl;

    public void generateRandomImage() {
        Random random = new Random();
        imageUrl = UrlBase.getAllUrls()[random.nextInt(UrlBase.getAllUrls().length)];
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public static void loadIntroImage(ImageView imageView, String imageUrl) {
        Bitmap bitmap;
        try {
            bitmap = BitmapFactory.decodeStream((new URL(imageUrl)).openConnection().getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        imageView.setImageBitmap(bitmap);
    }

    public static void loadIntroImageWithGlide(ImageView imageView, String imageUrl) {
        Glide.with(imageView)
                .load(imageUrl)
                .into(imageView);
    }
}
