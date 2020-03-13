package com.univ_amu.localizcci.viewmodels;

import android.app.Application;

import androidx.lifecycle.ViewModel;

import com.univ_amu.localizcci.data.Repository;
import com.univ_amu.localizcci.data.Spot;

import java.util.List;

public class SpotListViewModel  extends ViewModel {

    private final Repository repository;
    private final List<Spot> spots;

    public SpotListViewModel (Application application ,int categoryId){
        this.repository= new Repository(application);
        this.spots=repository.getSpots(categoryId);
    }


    public List<Spot> spots(){return  spots;}

}
