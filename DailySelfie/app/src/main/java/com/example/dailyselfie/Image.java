package com.example.dailyselfie;

import android.graphics.Bitmap;

public class Image {
    private Bitmap bitmap;
    private String name;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image(Bitmap bitmap, String name) {
        this.bitmap = bitmap;
        this.name = name;
    }


}
