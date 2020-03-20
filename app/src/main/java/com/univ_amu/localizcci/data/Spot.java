package com.univ_amu.localizcci.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

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
    //@ColumnInfo(name = "spot_name")
    private String name;

    //@ColumnInfo(name = "spot_date")
    public Date date;


    public Spot( Integer categoryId,Integer id, String name, Date date){

        this.categoryId= categoryId;
        this.id = id;
        this.name = name;
        this.date = date;
    };

    public int getCategoryId() {
        return categoryId;
    }

    public int getId() {return id;}

    @NonNull
    public String getName() {return name;}

    public Date getDate() {return date;}
}
