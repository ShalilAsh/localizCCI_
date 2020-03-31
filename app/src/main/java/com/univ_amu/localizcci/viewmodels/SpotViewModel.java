package com.univ_amu.localizcci.viewmodels;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.squareup.picasso.Picasso;
import com.univ_amu.localizcci.data.Repository;
import com.univ_amu.localizcci.data.Spot;

import java.util.List;

public class SpotViewModel  extends ViewModel {
    private final Repository repository;
    private final LiveData<Spot> spot;


    public SpotViewModel(Application application, Integer spotId) {
        this.repository = new Repository(application);
        this.spot = repository.getSpot(spotId);


    }

    public LiveData<Spot> spot() {
        return spot;
    }

}
