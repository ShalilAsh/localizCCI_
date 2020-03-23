package com.univ_amu.localizcci.viewmodels;

import android.app.Application;
import android.view.View;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.univ_amu.localizcci.data.Repository;
import com.univ_amu.localizcci.data.Spot;
import com.univ_amu.localizcci.data.Category;
import com.univ_amu.localizcci.ui.SpotListFragmentDirections;

import java.util.List;

public class SpotListViewModel extends AndroidViewModel {

    private final Repository repository;
    private final LiveData<List<Spot>> spots;

    public SpotListViewModel (Application application, int categoryId){
        super(application);
        this.repository= new Repository(application);
        this.spots=repository.getSpots(categoryId); // modifs

        //this.spots=repository.getSpots(); // modifs
    }

    public LiveData<List<Spot>> spots() {
        return spots;
    }


//  a voir ********************************

    public void onSearch(View view) {
        NavDirections action = SpotListFragmentDirections.actionSpotListToSpot(view.getId());
        Navigation.findNavController(view).navigate(action);
    }


}
