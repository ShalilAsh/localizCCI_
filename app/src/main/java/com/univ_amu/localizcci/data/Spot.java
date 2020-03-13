package com.univ_amu.localizcci.data;

import java.util.Date;

public class Spot {

    public int categoryId;
    public int id;
    public String name;
    public Date date;
    //public int imgid;


    public Spot(int id, int categoryId, String name, Date date){
        this.id = id;
        this.categoryId= categoryId;
        this.name = name;
        this.date = date;
        //this.imgid= imgid;
    };

    public int getCategoryId() {
        return categoryId;
    }

    public int getId() {
        return id;
    }
}
