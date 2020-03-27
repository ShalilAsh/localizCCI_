package com.univ_amu.localizcci.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.univ_amu.localizcci.data.Repository;
import com.univ_amu.localizcci.data.Spot;
import com.univ_amu.localizcci.databinding.FragmentSpotListBinding;
import com.univ_amu.localizcci.viewmodels.SpotListViewModel;
import com.univ_amu.localizcci.viewmodels.SpotListViewModelFactory;

public class SpotListFragment extends Fragment {

    FragmentSpotListBinding binding;
    SpotListViewModel model;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSpotListBinding.inflate(inflater, container, false);

        // changer du nom : CategoryListModelView

        int id = SpotListFragmentArgs.fromBundle(getArguments()).getId();//****** Important

        model = ViewModelProviders.of(this,
                new SpotListViewModelFactory(getActivity().getApplication(), id)).get(SpotListViewModel.class);

        // affichage une liste avec ID , (FragmentArgs)

        binding.setModel(model);

        SpotListAdapter spotListAdapter = new SpotListAdapter();
        binding.setLifecycleOwner(this);

        binding.spotList.setAdapter(spotListAdapter);

        binding.spotList.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));

        /*model.spots().observe(this, list -> {
            spotListAdapter.submitList(list);
            binding.spotList.computeVerticalScrollExtent();
        });*/

        model.spots().observe(this, spotListAdapter :: submitList);

        spotListAdapter.setListener(this :: onSpot);
        return binding.getRoot();

    }


    private void onSpot(Spot spot) {
        NavDirections action = SpotListFragmentDirections.actionSpotListToSpot(spot.getId());
        Navigation.findNavController(getView()).navigate(action);
    }



/*
     private void onSpot(Spot spot) {
        model.downloadSpot(spot.id);
         NavDirections action = SpotListFragmentDirections.actionSpotListToSpot(spot.getId());
         Navigation.findNavController(getView()).navigate(action);
    }
 */



}
