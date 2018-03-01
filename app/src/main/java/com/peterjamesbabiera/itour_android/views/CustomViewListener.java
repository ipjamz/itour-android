package com.peterjamesbabiera.itour_android.views;

import android.view.View;

/**
 * Created by peter on 3/1/18.
 */

public interface CustomViewListener<T> {

    void onClick(View view, T object);

}
