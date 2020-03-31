package com.univ_amu.localizcci.data.network;

import androidx.annotation.NonNull;

import java.util.Date;

public class NetworkSpot {
    public int categoryId;
    public int id;
    public String name;
    public Date date;
    public String descriptionSpot;
    public double gps_altitude;
    public double gps_longitude;
    public String url;

    @NonNull
    @Override
    public String toString() {
        return "NetworkSpot {" +
                "categoryId='" + categoryId + '\'' +
                "Id='" + id + '\'' +
                " , Name='" + name + '\'' +
                " , Date='" + date + '\'' +
                " , descriptionSpot='" + descriptionSpot + '\'' +
                " , gps_altitude='" + gps_altitude + '\'' +
                " , gps_longitude='" + gps_longitude + '\'' +
                " , url='" + url + '\'' +

                "}";
    }

/*
    public String gps(){

       return " , Gps Spot : altitude : "+ gps.altitude + '\'' + "longitude : "+gps.longitude + '\'' + " ";

    }
    */

}
