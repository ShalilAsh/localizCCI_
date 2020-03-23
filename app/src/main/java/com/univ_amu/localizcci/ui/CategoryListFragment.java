package com.univ_amu.localizcci.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.univ_amu.localizcci.data.Category;
import com.univ_amu.localizcci.data.Repository;
import com.univ_amu.localizcci.databinding.FragmentCategoryBinding;
import com.univ_amu.localizcci.databinding.FragmentCategoryListBinding;
import com.univ_amu.localizcci.ui.CategoryListAdapter;
import com.univ_amu.localizcci.viewmodels.CategoryListViewModel;

public class CategoryListFragment extends Fragment {

    FragmentCategoryListBinding binding;

    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

       binding = FragmentCategoryListBinding.inflate(inflater,container ,false);

        // changer du nom : SpotListModelView
        CategoryListViewModel model = ViewModelProviders.of(this).get(CategoryListViewModel.class);
        binding.setModel(model);

        CategoryListAdapter categoryListAdapter = new CategoryListAdapter();
        binding.setLifecycleOwner(this);

        binding.categoryList.setAdapter(categoryListAdapter);

        binding.categoryList.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));

        model.categories().observe(this, list -> {
            categoryListAdapter.submitList(list);
            binding.categoryList.computeVerticalScrollExtent();
        });


        categoryListAdapter.setListener(this :: onCategory);
        return binding.getRoot();


    }




    private void onCategory(Category category) {
        NavDirections action = CategoryListFragmentDirections.actionCategoryListToSpotList(category.getId());
        Navigation.findNavController(getView()).navigate(action); // modif
        //Navigation.findNavController(binding.getRoot()).navigate(action);

    }


}
