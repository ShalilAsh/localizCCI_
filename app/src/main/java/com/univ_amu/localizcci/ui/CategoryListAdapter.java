package com.univ_amu.localizcci.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.univ_amu.localizcci.data.Category;
import com.univ_amu.localizcci.databinding.CategoryItemBinding;

public class CategoryListAdapter extends ListAdapter <Category, CategoryListAdapter.ViewHolder> {

    private onCategoryListener listener;


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

        public void onClick(View view) {
            if (listener != null) listener.onCategory(category);
            // passer le Variable cateegory.code or id
            //NavDirections action = CategoryListFragmentDirections.actionCategoryListToSpotList();
            //Navigation.findNavController(binding.getRoot()).navigate(action);

        }


        public ViewHolder(@NonNull CategoryItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
            //this.binding.setViewHolder(this);
        }

        void bind(Category category){this.category=category; binding.invalidateAll();}




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


    // custom listener :
    public interface onCategoryListener {
        void onCategory(Category category);
    }

    // setListenner :

    public void setListener(onCategoryListener listener) {
        this.listener = listener;
    }




}
