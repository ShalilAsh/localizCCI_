package com.univ_amu.localizcci.data;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.univ_amu.localizcci.R;

@Entity (indices = {@Index(value = {"categoryId"},
        unique = true)})

public class Category {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "categoryId")
    public int id;
    @NonNull
    public  String name;
    @NonNull
    public String description;

    public int imgid;

    public Category(int id ,String name, String description, int  imgid) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgid = imgid;
    }


    public int getId() {
        return id;
    }
}
