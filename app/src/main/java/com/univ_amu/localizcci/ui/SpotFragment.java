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
import com.univ_amu.localizcci.viewmodels.SpotViewModel;
import com.univ_amu.localizcci.viewmodels.SpotViewModelFactory;

public class SpotFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentSpotBinding binding =FragmentSpotBinding.inflate(inflater,container,false);

        int id = SpotFragmentArgs.fromBundle(getArguments()).getId();

        SpotViewModel model = ViewModelProviders.of(this,
                new SpotViewModelFactory(getActivity().getApplication(),id)).get(SpotViewModel.class);

        binding.setModel(model); // creation model dans le layout fragmentspotlist.xml
        return binding.getRoot();


    }




}
