package com.univ_amu.localizcci.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.univ_amu.localizcci.data.Repository;
import com.univ_amu.localizcci.data.Spot;
import com.univ_amu.localizcci.databinding.FragmentSpotBinding;
import com.univ_amu.localizcci.databinding.FragmentSpotListBinding;
import com.univ_amu.localizcci.viewmodels.SpotListViewModel;
import com.univ_amu.localizcci.viewmodels.SpotListViewModelFactory;

import java.util.List;

public class SpotFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        FragmentSpotListBinding binding = FragmentSpotListBinding.inflate(inflater, container, false);

        int id = SpotListFragmentArgs.fromBundle(getArguments()).getId();//******

        //Log.d("SpotListFragment : ", "CategoryId = "+id);

        SpotListViewModel model = ViewModelProviders.of(this,
                new SpotListViewModelFactory(getActivity().getApplication(), id)).get(SpotListViewModel.class);


        binding.setModel(model);// creation model dans le layout fragmentspotlist.xml

        /*SpotListAdapter adapter = new SpotListAdapter();

        List<Spot> spots = model.spot;
        //Log.d("SpotListFragment : ", ""+spots.size());
        adapter.submitList(spots);
        binding.spotList.setAdapter(adapter); */

        return binding.getRoot();

    }
}
