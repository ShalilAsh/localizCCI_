package com.univ_amu.localizcci.ui;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.univ_amu.localizcci.data.Category;
import com.univ_amu.localizcci.data.Spot;
import com.univ_amu.localizcci.databinding.CategoryItemBinding;
import com.univ_amu.localizcci.databinding.FragmentCategoryBindingImpl;

public class CategoryListAdapter extends ListAdapter <Category, CategoryListAdapter.ViewHolder> {


    CategoryListAdapter() {
        super(diffUtilCallback);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        CategoryItemBinding binding = CategoryItemBinding.inflate(layoutInflater,parent,false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(getItem(position));

    }


    public class ViewHolder extends  RecyclerView.ViewHolder {

        public Category category;
        public CategoryItemBinding binding;

        public ViewHolder(@NonNull CategoryItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
            this.binding.setViewHolder(this);
        }

        void bind(Category category){this.category=category; binding.invalidateAll();}

        public void onClick(View view) {
            // passer le Variable cateegory.code or id
            NavDirections action = CategoryListFragmentDirections.actionCategoryListToSpotList(category.getId());
            Navigation.findNavController(binding.getRoot()).navigate(action);

        }


    }

    private static final DiffUtil.ItemCallback<Category> diffUtilCallback =
            new DiffUtil.ItemCallback<Category>() {
                @Override
                public boolean areItemsTheSame(Category oldCategory, Category newCategory) {
                    return oldCategory.id== newCategory.id;
                }
                @Override
                public boolean areContentsTheSame(Category oldCategory, Category newCategory) {
                    return this.areItemsTheSame(oldCategory, newCategory);
                }
            };

}
