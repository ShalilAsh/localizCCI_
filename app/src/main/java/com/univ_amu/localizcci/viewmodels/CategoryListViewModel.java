package com.univ_amu.localizcci.viewmodels;

import android.app.Application;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.univ_amu.localizcci.data.Category;
import com.univ_amu.localizcci.data.Repository;
import com.univ_amu.localizcci.ui.CategoryListFragmentDirections;

import java.util.List;

public class CategoryListViewModel extends AndroidViewModel {


    private final Repository repository;
    private final LiveData<List<Category>> categories;



    public CategoryListViewModel(Application application) {
        super(application);
        //this.repository = new Repository();
        //Modifiez les deux modèles de vue FoodListViewModel et FoodViewModel afin de passer l'application
        this.repository = new Repository(application);
        this.categories = repository.getCategories();
    }

    public LiveData<List<Category>> categories() {
        return categories;
    }

    public void onSearch(View view) { Log.i("Localiz", "onSearch"); }


/*
    public void onSearch(View view) {
        NavDirections action = CategoryListFragmentDirections.actionCategoryListToSpotList();
        Navigation.findNavController(view).navigate(action);
    }*/




}
