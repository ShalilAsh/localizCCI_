package com.univ_amu.localizcci.ui;

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

    private onSpotListener listener;

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
            this.binding.setViewHolder(this); // important
        }

        void bind(Spot spot){this.spot=spot; binding.invalidateAll();}


        /*public void onClick(View view) {
            NavDirections action = SpotListFragmentDirections.actionSpotListToSpot(spot.id);
            Navigation.findNavController(binding.getRoot()).navigate(action);

        }*/

        public void onClick(View view) {
            if (listener != null) listener.onCategory(spot);


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


    // custom listener :
    public interface onSpotListener {
        void onCategory(Spot spot);
    }

    // setListenner :
    public void setListener(onSpotListener listener) {
        this.listener = listener;
    }


}
