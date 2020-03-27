package com.univ_amu.localizcci.data;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.univ_amu.localizcci.R;

@Entity/*(
        tableName = "Category",
        indices = {@Index(value = {"name", "description"},
        unique = true)})*/

public class Category {
    @PrimaryKey
    public Integer id;

    @NonNull
    public  String name;

    @NonNull
    public String description;

    public int imgid;

    public Category(Integer id ,String name, String description, Integer imgid) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgid = imgid;
    }


    @NonNull
    public Integer getId() {
        return id;
    }

    @NonNull
    public String getName() { return name;}

    @NonNull
    public String getDescription() {return description;}
}
