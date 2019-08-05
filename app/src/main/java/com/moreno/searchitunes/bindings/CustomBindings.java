package com.moreno.searchitunes.bindings;

import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.moreno.searchitunes.R;

public class CustomBindings {

    @BindingAdapter("setAdapter")
    public static void bindRecyclerViewAdapter(RecyclerView recyclerView, RecyclerView.Adapter<?> adapter) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("imageUrl")
    public static void bindRecyclerViewAdapter(ImageView imageView, String imageUrl) {
        if (imageUrl != null) {
            Glide.with(imageView)
                    .load(imageUrl)
                    .placeholder(R.drawable.ic_movie_grey_24dp)
                    .into(imageView);
        }
    }
}
