package com.moreno.searchitunes.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.moreno.searchitunes.Constants;
import com.moreno.searchitunes.R;
import com.moreno.searchitunes.adapters.TrackListAdapter;
import com.moreno.searchitunes.databinding.ActivityTracklistBinding;
import com.moreno.searchitunes.models.Track;
import com.moreno.searchitunes.viewmodels.TrackListViewModel;

import java.util.List;

public class TrackListActivity extends AppCompatActivity {


    TrackListViewModel trackListViewModel;
    ActivityTracklistBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracklist);

        setupBindings();

        subscribeObservers();
    }

    private void setupBindings() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tracklist);
        trackListViewModel = ViewModelProviders.of(this).get(TrackListViewModel.class);
        binding.setViewmodel(trackListViewModel);
        binding.recyclerTracks.setAdapter(trackListViewModel.getAdapter());
        binding.recyclerTracks.setLayoutManager(new LinearLayoutManager(this));
        trackListViewModel.getAdapter().setOnItemClickListener(new TrackListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Track track) {
                Intent intent = new Intent(TrackListActivity.this, DetailActivity.class);
                intent.putExtra(Constants.EXTRA_TRACK, track);
                startActivity(intent);
            }
        });
    }

    // Listen for changes of data/list
    private void subscribeObservers() {
        trackListViewModel.getTracks().observe(this, new Observer<List<Track>>() {
            @Override
            public void onChanged(@Nullable List<Track> tracks) {
                    trackListViewModel.setTracksToAdapter(tracks);

            }
        });

    }

    @Override
    protected void onDestroy() {
        trackListViewModel.setLastVisit(System.currentTimeMillis());
        super.onDestroy();
    }
}
