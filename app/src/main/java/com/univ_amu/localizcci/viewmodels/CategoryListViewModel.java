package com.univ_amu.localizcci.viewmodels;

import android.app.Application;
import android.util.Log;
import android.view.View;
import android.widget.Toolbar;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.univ_amu.localizcci.R;
import com.univ_amu.localizcci.data.Category;
import com.univ_amu.localizcci.data.Repository;
import com.univ_amu.localizcci.databinding.ActivityMainBinding;
import com.univ_amu.localizcci.ui.CategoryListFragmentDirections;
import com.univ_amu.localizcci.ui.MainActivity;

import java.util.List;

public class CategoryListViewModel extends AndroidViewModel {


    private final Repository repository;
    private final LiveData<List<Category>> categories;
    private ActivityMainBinding binding;



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

    //public void onSearch(View view) { Log.i("Localiz", "onSearch"); }


    // a voir ***************************************


    public void onSearch(View view) {
        //repository.downloadSpot(view.getId());
        NavDirections action = CategoryListFragmentDirections.actionCategoryListToMapFragment();
        Navigation.findNavController(view).navigate(action);
    }

    public void onAdd(View view) {
        //binding = (ActivityMainBinding) DataBindingUtil.setContentView(this, R.layout.formulaire_activity);
        //NavDirections action = CategoryListFragmentDirections.actionCategoryListToFormulaiare();
        //Navigation.findNavController().navigate(action);
    }




    //  New methode :  use downloadSpot in categoryList Fragment :

    public void downloadSpot(Integer id) {
        repository.downloadSpot(id);
    }


}
