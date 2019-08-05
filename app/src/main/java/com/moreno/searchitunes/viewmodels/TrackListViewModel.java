package com.moreno.searchitunes.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.moreno.searchitunes.Constants;
import com.moreno.searchitunes.adapters.TrackListAdapter;
import com.moreno.searchitunes.models.Track;
import com.moreno.searchitunes.repositories.TrackRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TrackListViewModel extends AndroidViewModel {

    private TrackListAdapter trackListAdapter;

    private TrackRepository trackRepository;

    public TrackListViewModel(@NonNull Application application){
        super(application);
        trackRepository = TrackRepository.getInstance(application);
        init();
    }

    public void init() {
        trackListAdapter = new TrackListAdapter(this);

    }

    public LiveData<List<Track>> getTracks(){
        return trackRepository.getTracks();
    }

    public TrackListAdapter getAdapter(){
        return trackListAdapter;
    }

    public void setTracksToAdapter(List<Track> list){
        trackListAdapter.setTrackList(list);
    }

    public void setLastVisit(long time){
        trackRepository.save(Constants.KEY_LAST_CHECK, time);
    }

    public String getLastVisit(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, hh:mm aa");
        long timeInMillis = trackRepository.get(Constants.KEY_LAST_CHECK);
        Date date = new Date();
        date.setTime(timeInMillis);
        String lastVisit = timeInMillis > 0 ? "Last Visit: " + simpleDateFormat.format(date) : "";

        return lastVisit;
    }
}
