package com.univ_amu.localizcci.ui;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.univ_amu.localizcci.data.Spot;
import com.univ_amu.localizcci.databinding.SpotItemBinding;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;


public class SpotListAdapter extends ListAdapter<Spot, SpotListAdapter.ViewHolder> {

    SpotListAdapter() {super(diffUtilCallback); }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        SpotItemBinding binding = SpotItemBinding.inflate(layoutInflater,parent,false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(getItem(position));

    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        public Spot spot;
        public SpotItemBinding binding;

        public ViewHolder(@NonNull SpotItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
            this.binding.setViewHolder(this);
        }

        void bind(Spot spot){this.spot=spot; binding.invalidateAll();}


        public void onClick(View view) {

            //Log.i("LocalizCCI", "Click on "+spot.categoryId);

            NavDirections action = SpotListFragmentDirections.actionSpotListToSpot(spot.id);
            Navigation.findNavController(binding.getRoot()).navigate(action);

        }

    }







        private static final DiffUtil.ItemCallback<Spot> diffUtilCallback =
            new DiffUtil.ItemCallback<Spot>() {
                @Override
                public boolean areItemsTheSame(Spot oldSpot, Spot newSpot) {
                    return oldSpot.id== newSpot.id;
                }
                @Override
                public boolean areContentsTheSame(Spot oldSpot, Spot newSpot) {
                    return this.areItemsTheSame(oldSpot, newSpot);
                }
            };




}
