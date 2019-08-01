package com.moreno.searchitunes.repositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.moreno.searchitunes.api.Api;
import com.moreno.searchitunes.api.TrackApiClient;
import com.moreno.searchitunes.models.Track;

import java.util.List;

public class TrackRepository {

    private static TrackRepository instance;
    private MediatorLiveData<List<Track>> trackList = new MediatorLiveData<>();
    private TrackApiClient trackApiClient;


    public static TrackRepository getInstance(){
        if (instance == null)
            instance = new TrackRepository();
        return instance;
    }

    private TrackRepository(){
        trackApiClient = TrackApiClient.getInstance();
        init();
    }

    private void init() {
        LiveData<List<Track>> trackListApiSource = trackApiClient.getTracks();
        trackList.addSource(trackListApiSource, new Observer<List<Track>>() {
            @Override
            public void onChanged(@Nullable List<Track> tracks) {
                //TODO
            }
        });
    }

    public LiveData<List<Track>> getTracks(){
        return trackList;
    }

}
