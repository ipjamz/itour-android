package com.peterjamesbabiera.itour_android.data;

import android.graphics.Bitmap;

/**
 * Created by peter on 2/28/18.
 */

public class Attraction {

    private Bitmap image;
    private String name;

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
