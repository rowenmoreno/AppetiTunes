package com.moreno.searchitunes.repositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.moreno.searchitunes.api.Api;
import com.moreno.searchitunes.api.TrackApiClient;
import com.moreno.searchitunes.api.responsemodel.TrackListResponse;
import com.moreno.searchitunes.models.Track;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        final MutableLiveData<List<Track>> tracks = new MutableLiveData<>();
        Api.getTrackApi().getTracks("star","au", "movie").enqueue(new Callback<TrackListResponse>() {
            @Override
            public void onResponse(Call<TrackListResponse> call, Response<TrackListResponse> response) {
                tracks.setValue(response.body().getTracks());
            }

            @Override
            public void onFailure(Call<TrackListResponse> call, Throwable t) {

            }
        });
        return tracks;
    }



}
