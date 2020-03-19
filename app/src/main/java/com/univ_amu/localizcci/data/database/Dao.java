package com.univ_amu.localizcci.data.database;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.univ_amu.localizcci.data.Category;
import com.univ_amu.localizcci.data.Spot;

import java.util.List;


@androidx.room.Dao
public interface Dao {

    @Query("SELECT * FROM Category ")
    LiveData <List<Category>> getCategories();

    @Query("SELECT * FROM Spot ORDER BY date DESC")
    LiveData <List<Spot>> getSpots();

    @Query("SELECT * FROM Spot  WHERE categoryId = :categoryId")
    LiveData <List<Spot>> getSpots(int categoryId);

    @Query("SELECT * FROM Spot WHERE id = :id ")
    LiveData<Spot> getSpot(int id );

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCategories(List<Category> categories);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCategory(Category category);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSpot(Spot spot, int categoryId);

}
