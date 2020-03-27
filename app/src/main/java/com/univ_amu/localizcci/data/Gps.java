package com.univ_amu.localizcci.data;


import androidx.room.Entity;

@Entity ( tableName = "Gps",
        primaryKeys = { "altitude","longitude"})
public class Gps {

    public double altitude;
    public double longitude;


    public Gps(double altitude, double longitude) {
        this.altitude = altitude;
        this.longitude = longitude;
    }


    public double getLongitude() {
        return longitude;
    }

    public double getAltitude() {
        return altitude;
    }


    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
