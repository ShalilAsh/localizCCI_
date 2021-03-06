package com.univ_amu.localizcci.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class SpotListViewModelFactory implements ViewModelProvider.Factory{

    private final Application application;
    private final int id;

    public SpotListViewModelFactory (Application application, int id){

        this.application=application;
        this.id=id;
    }

    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(SpotListViewModel.class)) {
            return (T) new SpotListViewModel(application, id);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }




}
