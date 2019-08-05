package com.moreno.searchitunes.adapters;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.moreno.searchitunes.BR;
import com.moreno.searchitunes.models.Track;
import com.moreno.searchitunes.viewmodels.TrackListViewModel;

public class HeaderViewHolder extends RecyclerView.ViewHolder {
    ViewDataBinding binding;

    HeaderViewHolder(ViewDataBinding binding){
        super(binding.getRoot());
        this.binding = binding;
    }

    void bind(TrackListViewModel viewModel){
        binding.setVariable(BR.viewmodel, viewModel);
        binding.executePendingBindings();
    }
}
