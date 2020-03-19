package com.univ_amu.localizcci.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;


@Entity (
        foreignKeys = {
@ForeignKey(
        entity = Category.class,
        parentColumns = "categoryId",
        childColumns = "categoryId",
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE)})

public class Spot {

    @NonNull
    public int categoryId;
    @PrimaryKey
    @NonNull
    public int id;
    @NonNull
    public String name;
    public Date date;


    public Spot( int categoryId,int id, String name, Date date){

        this.categoryId= categoryId;
        this.id = id;
        this.name = name;
        this.date = date;
    };

    public int getCategoryId() {
        return categoryId;
    }
}
