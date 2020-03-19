package com.univ_amu.localizcci.data.network;

import androidx.annotation.NonNull;

import java.util.Date;

public class NetworkSpot {
    public int categoryId;
    public int id;
    public String name;
    public Date date;

    @NonNull
    @Override
    public String toString() {
        return "NetworkSpot {" +
                "categoryId='" + categoryId + '\'' +
                "Id='" + id + '\'' +
                " , Name='" + name + '\'' +
                " , Date='" + date + '\'' +
                "}";
    }
}
