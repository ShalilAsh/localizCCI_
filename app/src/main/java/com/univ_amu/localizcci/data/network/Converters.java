package com.univ_amu.localizcci.data.network;


import com.univ_amu.localizcci.data.Spot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class  Converters {

    public static Spot getSpot(NetworkSpot spot) {
        Spot spot1 = new Spot( spot.categoryId , spot.id,spot.name,new Date(), spot.descriptionSpot, spot.gps_altitude,spot.gps_longitude);
        return spot1;
    }

    public static List<Spot> getSpots(List <NetworkSpot> spots) {
        List<Spot> result = new ArrayList<>();

        for (NetworkSpot spot : spots) {
        result.add(new Spot(spot.categoryId, spot.id,spot.name,new Date(),spot.descriptionSpot , spot.gps_altitude,spot.gps_longitude ));

        }
        return result;
    }


}

