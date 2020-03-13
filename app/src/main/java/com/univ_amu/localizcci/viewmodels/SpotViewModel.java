package com.univ_amu.localizcci.viewmodels;

import android.app.Application;

import androidx.lifecycle.ViewModel;

import com.univ_amu.localizcci.data.Repository;
import com.univ_amu.localizcci.data.Spot;

public class SpotViewModel extends ViewModel {

    private final Repository repository;
    private final Spot spot;

    public  SpotViewModel (Application application  , int spotId){
        this.repository=new Repository();
        this.spot=repository.getSpot(spotId);
    }

    public Spot spot() { return spot;}

}
