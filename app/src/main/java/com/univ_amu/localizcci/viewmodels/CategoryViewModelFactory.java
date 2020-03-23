package com.univ_amu.localizcci.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class CategoryViewModelFactory implements ViewModelProvider.Factory{

    private final Application application;
    private final Integer id;

    public CategoryViewModelFactory(Application application, Integer id) {
        this.application = application;
        this.id = id;
    }


    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(CategoryViewModelFactory.class)) {
            return (T) new CategoryListViewModel(application);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }



}
