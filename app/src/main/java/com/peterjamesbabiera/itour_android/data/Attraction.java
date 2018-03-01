package com.peterjamesbabiera.itour_android.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by peter on 2/28/18.
 */

public class Attraction implements Parcelable {
    private int imageId;
    private String name;
    private String info;
    private int infoImageId;
    private LatLng latLng;

    public Attraction() {
    }

    protected Attraction(Parcel in) {
        imageId = in.readInt();
        name = in.readString();
        info = in.readString();
        infoImageId = in.readInt();
        latLng = in.readParcelable(LatLng.class.getClassLoader());
    }

    public static final Creator<Attraction> CREATOR = new Creator<Attraction>() {
        @Override
        public Attraction createFromParcel(Parcel in) {
            return new Attraction(in);
        }

        @Override
        public Attraction[] newArray(int size) {
            return new Attraction[size];
        }
    };

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getInfoImageId() {
        return infoImageId;
    }

    public void setInfoImageId(int infoImageId) {
        this.infoImageId = infoImageId;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(imageId);
        parcel.writeString(name);
        parcel.writeString(info);
        parcel.writeInt(infoImageId);
        parcel.writeParcelable(latLng, i);
    }
}
