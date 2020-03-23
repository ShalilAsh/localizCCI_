package com.univ_amu.localizcci.data;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.univ_amu.localizcci.R;
import com.univ_amu.localizcci.data.database.Dao;
import com.univ_amu.localizcci.data.database.Database;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    private final Context context;
    private final ExecutorService executor;
    private Dao dao;

    public Repository(Context context) {
        this.context = context;
        this.dao = null;
        executor = Executors.newSingleThreadExecutor();
        this.addCategoriesIfEmpty();
        this.addSpotsIfEmpty(); // this , this ,,, this
    }

    private Dao dao() {
        if (dao==null) {
            Database database = Database.getInstance(context);
            this.dao = database.dao();
        }
        return this.dao;
    }

    public LiveData<Integer> getCategoryCount() {return dao().getCategoryCount();}

    public LiveData<Integer> getSpotCount() {return dao().getSpotCount();}

    public LiveData<List<Category>> getCategories() { return dao().getCategories(); }

    public LiveData<List<Spot>> getSpots(int categoryId) { return dao().getSpots(categoryId); }

    public LiveData<List<Spot>> getSpots() {
        return dao().getSpots();
    }

    public LiveData<Spot> getSpot(int id) {
        return dao().getSpot(id);
    }


    public void insertSpot(Spot spot) { executor.execute(() -> dao().insertSpot(spot));}


    public void insertSpots(List<Spot> spots) {
        executor.execute(() -> dao().insertSpots(spots));
    }

    public void insertCategories(List<Category> categories) {
        executor.execute(() -> dao().insertCategories(categories));
    }


    public void addCategoriesIfEmpty() {
        getCategoryCount().observeForever(value -> {
            if (value != 0) return;
            addCategories();

        });
    }

    private void addCategories() {
         List<Category> categories = Arrays.asList(
                 new Category(0,"Incontounables", "Ce que tu ne dois pas louper",R.drawable.incontournables),
                 new Category(1,"Monuments & Musées", "Les classiques historiques" ,R.drawable.monuments),
                 new Category(2,"Nature", "Decouvrir le paysage" ,R.drawable.nature),
                 new Category(3,"Shopping", "Acheter un truc" ,R.drawable.shopping));
         insertCategories(categories);
         addSpots();

    }


    public void addSpotsIfEmpty (){
        getSpotCount().observeForever(value -> {
            if (value != 0) return;
            addSpots();
        });
    }




    private void addSpots() {
        spots = Arrays.asList(
                new Spot(0,0," Vieux port",new Date()),
                new Spot(0,1," La Vieille Charité ",new Date()),
                new Spot(0, 3," Notre dame de la garde",new Date()),
                new Spot(0, 4," Cathédrale de la Major",new Date()),
                new Spot(0, 5," Calanques de Marseille",new Date()),
                new Spot(3, 6," Calanques de Marseille",new Date()),
                new Spot(0,7," Friche La Belle-de-Mai ",new Date()),
                new Spot(0,8," L'Estaque ",new Date()),
                new Spot(0,9," Château d'If  ",new Date()),
                new Spot(1,10," Château d'If  ",new Date()),
                new Spot(3,11," Friche La Belle-de-Mai ",new Date())

        );
        insertSpots(spots);




    }



    private static List<Category> categories = Arrays.asList(new Category(0,"Incontounables", "Ce que tu ne dois pas louper",R.drawable.incontournables),
            new Category(1,"Monuments & Musées", "Les classiques historiques" ,R.drawable.monuments),
            new Category(2,"Nature", "Decouvrir le paysage" ,R.drawable.nature),
            new Category(3,"Shopping", "Acheter un truc" ,R.drawable.shopping));

    private static List<Spot> spots = Arrays.asList(
            new Spot(0,0," Vieux port",new Date()),
            new Spot(0,1," La Vieille Charité ",new Date()),
            new Spot(0, 3," Notre dame de la garde",new Date()),
            new Spot(0, 4," Cathédrale de la Major",new Date()),
            new Spot(0, 5," Calanques de Marseille",new Date()),
            new Spot(3, 6," Calanques de Marseille",new Date()),
            new Spot(0,7," Friche La Belle-de-Mai ",new Date()),
            new Spot(0,8," L'Estaque ",new Date()),
            new Spot(0,9," Château d'If  ",new Date()),
            new Spot(1,10," Château d'If  ",new Date()),
            new Spot(3,11," Friche La Belle-de-Mai ",new Date())

            );


}

