package com.peterjamesbabiera.itour_android.logic;

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
        event.setImageId(R.drawable.ic_dinagyang);
        event.setName("Dinagyang");
        event.setInfo("The Iloilo Dinagyang Festival is a showcase of the rich heritage, " +
                "colorful history, passionate devotion, and fun-loving spirit " +
                "of the Ilonggo people. The festival traces its roots as a " +
                "thanksgiving celebration in honor of Senyor Santo Niño, the child Jesus." +
                " Today, it has grown to be one of the Philippines’ most spectacular religious" +
                " and cultural festivals.");
        event.setInfoImageId(R.drawable.ic_dinagyang2);
        events.add(event);

        Attraction event2 = new Attraction();
        event2.setImageId(R.drawable.ic_dinagyang2);
        event2.setName("Ati-atihan");
        events.add(event2);

        return events;
    }

    public List<Attraction> getSites() {
        List<Attraction> sites = new ArrayList<>();

        Attraction site = new Attraction();
        site.setImageId(R.drawable.ic_dinagyang);
        site.setName("Dinagyang");
        sites.add(site);

        Attraction site2 = new Attraction();
        site2.setImageId(R.drawable.ic_dinagyang);
        site2.setName("Ati-atihan");
        sites.add(site2);

        return sites;
    }

}
