package com.univ_amu.localizcci.data.network;


import com.univ_amu.localizcci.data.Spot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Converters {

    public static Spot getSpot(NetworkSpot spot) {
        /* TODO */
        Spot spot1 = new Spot( spot.categoryId , spot.id,spot.name,new Date());
        return spot1;
    }


/*
    public static List<Spot> getSpots(int categoryId) {
        List<Spot> spots = new ArrayList<>();

        for (NetworkCategory category : category.categoryId) {

            quantities.add(new Quantity(food.code,
                    quantity.name,
                    quantity.rank,
                    quantity.level,
                    quantity.quantity,
                    quantity.unit));
        }

        return quantities;

    }

    public static List<Food> getFoods(List<NetworkFood> foods) {

        List<Food> result = new ArrayList<>();
        for (NetworkFood food : foods) {

            result.add(new Food(food.code, food.name, food.brands, food.nutriscore, new Date()));
        }
        return result;

    } */

}

