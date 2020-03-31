package com.univ_amu.localizcci.ui;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.google.zxing.BarcodeFormat;
import com.univ_amu.localizcci.R;
import com.univ_amu.localizcci.data.Repository;
import com.univ_amu.localizcci.data.Spot;
import com.univ_amu.localizcci.databinding.*;

import java.util.Collections;
import java.util.Date;

public class FormulaireFragment extends Fragment {

    private Repository repository;
    private FragmentFormulaireBinding binding;
    private  Spot spot;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.repository = new Repository(getContext());

        //this.spot=new Spot(setCategoryId(),setId(),setName(),
                //new Date(), setDescriptionSpot(),setGps_altitude(),setGps_longitude());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //binding = FragmentFormulaireBinding.inflate(inflater, container, false);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_formulaire, container, false);
        return binding.getRoot();

    }



/*
    private void onSpotDetected(Integer id) {
        // TODO : naviguer vers le fragment SpotFragment
        NavDirections Myaction = FormulaireFragmenDirections.actionFormulaireFragmentToSpotFragment(id);
        Navigation.findNavController(getView()).navigate(Myaction);
    }

    */


    @Override
    public void onResume() {
        super.onResume();
        //binding.scanner.startCamera();
        //binding.scanner.setFormats(Collections.singletonList(BarcodeFormat.EAN_13));
        //binding.scanner.setResultHandler(this :: handleResult);
    }

    @Override
    public void onPause() {
        super.onPause();
        //binding.scanner.stopCamera();
    }



    @Override
    public void onStart() {
        super.onStart();
        if (hasNoPermissions()) {
            requestPermission();
        }
        if (hasNoPermissions()) {
            navigateUp();
        }
    }



    private void requestPermission() {
        requestPermissions(new String[]{Manifest.permission.LOCATION_HARDWARE}, 0);
    }

    private boolean hasNoPermissions() {
        return ContextCompat.checkSelfPermission(this.getContext(), Manifest.permission.LOCATION_HARDWARE) != PackageManager.PERMISSION_GRANTED;
    }


    private void navigateUp() {
        Navigation.findNavController(binding.getRoot()).navigateUp();
    }









}

