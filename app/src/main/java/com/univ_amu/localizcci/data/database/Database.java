package com.univ_amu.localizcci.data.database;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.univ_amu.localizcci.data.Category;
import com.univ_amu.localizcci.data.Spot;

@androidx.room.Database(entities = {Category.class ,Spot.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class Database extends RoomDatabase {

    private static volatile Database database = null;
    public static synchronized Database getInstance(Context context) {
        if (database==null) {
            database = Room.databaseBuilder(context.getApplicationContext(),
                    Database.class, "database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;
    }

    public abstract Dao dao();
}