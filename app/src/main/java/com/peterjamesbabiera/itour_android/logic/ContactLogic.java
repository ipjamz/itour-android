package com.peterjamesbabiera.itour_android.logic;

import com.peterjamesbabiera.itour_android.data.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peter on 3/2/18.
 */

public class ContactLogic {

    private static ContactLogic instance;


    public static ContactLogic getInstance() {
        if (instance == null) {
            instance = new ContactLogic();
        }
        return instance;
    }

    public List<Contact> getContacts() {
        List<Contact> contacts = new ArrayList<>();

        Contact hospital = new Contact();
        hospital.setName("Medicus Medical Center");
        hospital.setNumber("09092212334");
        contacts.add(hospital);

        Contact police = new Contact();
        police.setName("Iloilo City Police Office");
        police.setNumber("09092212334");
        contacts.add(police);

        Contact emergencyHotline = new Contact();
        emergencyHotline.setName("Emergency Hotline");
        emergencyHotline.setNumber("911");
        contacts.add(emergencyHotline);

        return contacts;
    }

}
