package com.univ_amu.localizcci.data;


import com.univ_amu.localizcci.R;

public class Category {

    public int id;
    public  String name;
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
