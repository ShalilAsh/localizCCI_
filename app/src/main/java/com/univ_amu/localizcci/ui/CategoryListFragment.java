package com.univ_amu.localizcci.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.univ_amu.localizcci.data.Repository;
import com.univ_amu.localizcci.databinding.FragmentCategoryBinding;
import com.univ_amu.localizcci.databinding.FragmentCategoryListBinding;
import com.univ_amu.localizcci.ui.CategoryListAdapter;
import com.univ_amu.localizcci.viewmodels.CategoryListViewModel;

public class CategoryListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentCategoryListBinding binding = FragmentCategoryListBinding.inflate(inflater,container ,false);

        CategoryListViewModel model = ViewModelProviders.of(this).get(CategoryListViewModel.class);
        binding.setModel(model);
        CategoryListAdapter adapter = new CategoryListAdapter();
        adapter.submitList(model.categories());
        binding.categoryList.setAdapter(adapter);
        binding.categoryList.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));

        return binding.getRoot();

    }
}
