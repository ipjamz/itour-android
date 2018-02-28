package com.peterjamesbabiera.itour_android;

import android.app.Application;
import android.content.Context;

/**
 * Created by peter on 2/28/18.
 */

public class ITourApplication extends Application {

    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
