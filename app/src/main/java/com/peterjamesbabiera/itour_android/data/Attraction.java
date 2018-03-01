package com.peterjamesbabiera.itour_android.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by peter on 2/28/18.
 */

public class Attraction implements Parcelable {
    private int imageId;
    private String name;
    private String info;
    private int infoImageId;
    private double latitude;
    private double longitude;

    public Attraction() {
    }


    protected Attraction(Parcel in) {
        imageId = in.readInt();
        name = in.readString();
        info = in.readString();
        infoImageId = in.readInt();
        latitude = in.readDouble();
        longitude = in.readDouble();
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
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
        parcel.writeDouble(latitude);
        parcel.writeDouble(longitude);
    }
}
