package com.univ_amu.localizcci.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class SpotViewModelFactory implements ViewModelProvider.Factory {

    private final Application application;
    private final int id;


    public SpotViewModelFactory(Application application, int id) {
        this.application = application;
        this.id = id;
    }


    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(SpotViewModel.class)) {
            return (T) new SpotViewModel(application, id);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }

}
