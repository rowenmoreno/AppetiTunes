package com.moreno.searchitunes.api;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.AsyncTask;

import com.moreno.searchitunes.models.Track;

import java.util.List;

public class TrackApiClient {

    private static TrackApiClient instance;
    private MutableLiveData<List<Track>> trackList;

    public static  TrackApiClient getInstance(){
        if (instance == null)
            instance = new TrackApiClient();

        return instance;
    }

    public LiveData<List<Track>> getTracks(){
        return trackList;
    }




}
