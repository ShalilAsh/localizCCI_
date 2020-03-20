package com.univ_amu.localizcci.data;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.univ_amu.localizcci.R;

@Entity(
        tableName = "Category",
        indices = {@Index(value = {"name", "description"},
        unique = true)})

// @Entity
public class Category {
    @PrimaryKey
    public int id;

    @NonNull
    @ColumnInfo(name = "name")
    public  String name;

    @NonNull
    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "imgid")
    public int imgid;

    public Category(int id ,String name, String description, int  imgid) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgid = imgid;
    }


    @NonNull
    public int getId() {
        return id;
    }

    @NonNull
    public String getName() { return name;}

    @NonNull
    public String getDescription() {return description;}
}
