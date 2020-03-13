package com.univ_amu.localizcci.viewmodels;

import android.app.Application;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.AndroidViewModel;

import com.univ_amu.localizcci.data.Category;
import com.univ_amu.localizcci.data.Repository;

import java.util.List;

public class CategoryListViewModel extends AndroidViewModel {

    private final Repository repository;
    private final List<Category> categories;

    public CategoryListViewModel(Application application) {
        super(application);
        this.repository = new Repository();
        this.categories = repository.getCategories();
    }

    public List<Category> categories() { return categories; }


    public void onSearch(View view) { Log.i("Localiz", "onSearch"); }

}
