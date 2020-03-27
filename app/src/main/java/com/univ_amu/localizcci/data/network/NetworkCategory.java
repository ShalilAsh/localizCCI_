package com.univ_amu.localizcci.data.network;

import androidx.annotation.NonNull;

public class NetworkCategory {

    public int id;
    public  String name;
    public String description;
    public int imgid;

    @NonNull
    @Override
    public String toString() {
        return "NetworkCategory {" +
                "Id='" + id + '\'' +
                " , Name='" + name + '\'' +
                " , Description='" + description + '\'' +
                " , imgid='" + imgid + "}";
    }
}
