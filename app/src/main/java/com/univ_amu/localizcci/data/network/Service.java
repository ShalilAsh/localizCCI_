package com.univ_amu.localizcci.data.network;

/* Created by SHALIL Ash_saleh on 2/10/20.
 */

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Service {
    @GET("/spot/{id}")
    Call<NetworkSpot> getSpot(@Path("id") Integer id);

    @GET("/spots/{categoryId}")
    Call<List<NetworkSpot>>  getSpots(@Path("categoryId") Integer categoryId);

    @GET("/category/{id}")
    Call<NetworkCategory> getCategory(@Path("id") Integer id);

    /*
    @GET("/search/{query}")
    Call<List<NetworkSpot>> searchSpot(@Path("query")String query); */
}