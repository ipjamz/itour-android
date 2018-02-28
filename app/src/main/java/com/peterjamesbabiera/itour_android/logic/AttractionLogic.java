package com.peterjamesbabiera.itour_android.logic;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.peterjamesbabiera.itour_android.ITourApplication;
import com.peterjamesbabiera.itour_android.R;
import com.peterjamesbabiera.itour_android.data.Attraction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peter on 2/28/18.
 */

public class AttractionLogic {

    private static AttractionLogic instance;


    public static AttractionLogic getInstance() {
        if (instance == null) {
            instance = new AttractionLogic();
        }
        return instance;
    }

    public List<Attraction> getEvent() {
        List<Attraction> events = new ArrayList<>();

        Attraction event = new Attraction();
        Bitmap image = BitmapFactory.decodeResource(ITourApplication.getContext().getResources(), R.drawable.ic_dinagyang);
        event.setImage(image);
        event.setName("Dinagyang");
        events.add(event);

        Attraction event2 = new Attraction();
        Bitmap image2 = BitmapFactory.decodeResource(ITourApplication.getContext().getResources(), R.drawable.ic_dinagyang);
        event2.setImage(image2);
        event2.setName("Ati-atihan");
        events.add(event2);

        return events;
    }

    public List<Attraction> getSites() {
        List<Attraction> sites = new ArrayList<>();

        Attraction site = new Attraction();
        Bitmap image = BitmapFactory.decodeResource(ITourApplication.getContext().getResources(), R.drawable.ic_dinagyang);
        site.setImage(image);
        site.setName("Dinagyang");
        sites.add(site);

        Attraction site2 = new Attraction();
        Bitmap image2 = BitmapFactory.decodeResource(ITourApplication.getContext().getResources(), R.drawable.ic_dinagyang);
        site2.setImage(image2);
        site2.setName("Ati-atihan");
        sites.add(site2);

        return sites;
    }
}
