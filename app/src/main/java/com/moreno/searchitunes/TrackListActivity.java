package com.moreno.searchitunes;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.moreno.searchitunes.models.Track;
import com.moreno.searchitunes.viewmodels.TrackListViewModel;

import java.util.List;

public class TrackListActivity extends BaseActivity {

    TrackListViewModel trackListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracklist);

        trackListViewModel = ViewModelProviders.of(this).get(TrackListViewModel.class);

        subscribeObservers();
    }

    private void subscribeObservers() {
        trackListViewModel.getTracks().observe(this, new Observer<List<Track>>() {
            @Override
            public void onChanged(@Nullable List<Track> tracks) {
                Log.v("test","test");
            }
        });
    }
}
