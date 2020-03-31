package com.univ_amu.localizcci.data;

import android.location.Location;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.Date;


@Entity ( tableName = "Spot",
        primaryKeys = { "id"},
        foreignKeys = {
@ForeignKey(
        entity = Category.class,
        parentColumns = "id",
        childColumns = "categoryId",
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE)})


public class Spot {

    @NonNull
    public Integer categoryId;
    public Integer id;
    @NonNull
    public String name;
    public Date date;
    public   String descriptionSpot;
    public double gps_altitude;
    public double gps_longitude;
    public String gps;
    public String urlImage;
    //public ImageView imgSpot;



    public Spot( Integer categoryId,Integer id, String name, Date date, String descriptionSpot,double gps_altitude, double gps_longitude, String urlImage){
        this.categoryId= categoryId;
        this.id = id;
        this.name = name;
        this.date = date;
        this.descriptionSpot=descriptionSpot;
        this.gps_altitude = gps_altitude;
        this.gps_longitude=gps_longitude;
        this.gps = " Coordonnées GPS : " +String.valueOf(gps_altitude)+" , " + String.valueOf(gps_longitude);
        this.urlImage= urlImage;
    }


    public Integer getCategoryId() {
        return categoryId;
    }

    public Integer getId() {return id;}

    @NonNull
    public String getName() {return name;}


    public Date getDate() {return date;}

    public String getDescriptionSpot() {
        return descriptionSpot;
    }

    public double getGps_altitude() {
        return gps_altitude;
    }

    public double getGps_longitude() {
        return gps_longitude;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(double altitude , double longitude) {
        this.gps = " Coordonnées GPS : " +String.valueOf(gps_altitude)+" , " + String.valueOf(gps_longitude);
    }


    @BindingAdapter("android:urlLoad")
    public static void setImageUrl(ImageView view, String url) {
        if(url == null) return;
        Log.d("setImageurl", url);
        Glide.with(view).load(url).into(view);
    }




}


