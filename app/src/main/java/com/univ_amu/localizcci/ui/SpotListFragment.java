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

public class SpotListFragment extends Fragment {

    FragmentSpotListBinding binding;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSpotListBinding.inflate(inflater, container, false);

        // changer du nom : CategoryListModelView
        SpotListViewModel model = ViewModelProviders.of(this).get(SpotListViewModel.class);
        binding.setModel(model);

        SpotListAdapter spotListAdapter = new SpotListAdapter();
        binding.setLifecycleOwner(this);

        binding.spotList.setAdapter(spotListAdapter);

        binding.spotList.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));

        model.spots().observe(this, list -> {
            spotListAdapter.submitList(list);
            binding.spotList.computeVerticalScrollExtent();
        });

        spotListAdapter.setListener(this :: onSpot);
        return binding.getRoot();

    }


    private void onSpot(Spot spot) {
        NavDirections action = SpotListFragmentDirections.actionSpotListToSpot(spot.getId());
        Navigation.findNavController(getView()).navigate(action);
    }

}
