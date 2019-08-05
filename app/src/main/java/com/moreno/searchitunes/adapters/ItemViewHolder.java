package com.moreno.searchitunes.adapters;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.moreno.searchitunes.BR;
import com.moreno.searchitunes.models.Track;
import com.moreno.searchitunes.viewmodels.TrackListViewModel;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    ViewDataBinding binding;

    ItemViewHolder(ViewDataBinding binding){
        super(binding.getRoot());
        this.binding = binding;
    }

    void bind(final Track track, TrackListViewModel viewModel, final TrackListAdapter.OnItemClickListener onItemClickListener){
        binding.setVariable(BR.track, track);
        binding.setVariable(BR.viewmodel, viewModel);
        binding.executePendingBindings();
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null)
                    onItemClickListener.onItemClick(track);
            }
        });
    }
}
