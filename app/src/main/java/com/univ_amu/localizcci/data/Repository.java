package com.univ_amu.localizcci.data;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.univ_amu.localizcci.R;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Repository {

    Application application;
    public Repository() {

    }

    public Repository (Application application) {
        this.application=application;

    }


    public List<Category> getCategories() {
        return categories;
    }

    public int getCategoryId (Category category) {
        return  category.getId();
    }

    /*

    public int getCategoryId () {

        return 0;
    }
    */


   /* public  List<Spot> getSpots () {
        return spots;
    } */


    public  List<Spot> getSpots (int categoryId) {

        return spots.stream()
                .filter(spot-> spot.categoryId == categoryId).collect(Collectors.toList());
    }

    public Spot getSpot(int spotId) {
        return spots.stream()
                .filter(spot-> spot.id== spotId)
                .findFirst()
                .get();
    }



    private static List<Category> categories = Arrays.asList(new Category(0,"Incontounables", "Ce que tu ne dois pas louper",R.drawable.incontournables),
            new Category(1,"Monuments & Musées", "Les classiques historiques" ,R.drawable.monuments),
            new Category(2,"Nature", "Decouvrir le paysage" ,R.drawable.nature),
            new Category(3,"Shopping", "Acheter un truc" ,R.drawable.shopping));


    private static List<Spot> spots = Arrays.asList(
            new Spot(0,0," Vieux port",new Date()),
            new Spot(1,0," La Vieille Charité ",new Date()),
            new Spot(2, 0," Notre dame de la garde",new Date()),
            new Spot(3, 0," Cathédrale de la Major",new Date()),
            new Spot(4, 0," Calanques de Marseille",new Date()),
            new Spot(5, 2," Calanques de Marseille",new Date()),
            new Spot(6,0," Friche La Belle-de-Mai ",new Date()),
            new Spot(7,0," L'Estaque ",new Date()),
            new Spot(8,0," Château d'If  ",new Date()),
            new Spot(9,1," Château d'If  ",new Date()),
            new Spot(10,2," Friche La Belle-de-Mai ",new Date()),
            new Spot(11,2," la calanque de Sormiou  ",new Date()),
            new Spot(12,2,"  le massif de l'Étoile   ",new Date()),
            new Spot(13,2,"  la Sainte-Victoire   ",new Date()),
            new Spot(14,3,"  Les Terrasses du Port  ",new Date()),
            new Spot(15,3,"  Centre Commercial Centre Bourse  ",new Date()),
            new Spot(16,1," Musée d'histoire de Marseille  ",new Date())


    );




}

