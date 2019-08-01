package com.moreno.searchitunes.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.moreno.searchitunes.models.Track;
import com.moreno.searchitunes.repositories.TrackRepository;

import java.util.List;

public class TrackListViewModel extends ViewModel {

    private TrackRepository trackRepository;

    public TrackListViewModel(){
        trackRepository = TrackRepository.getInstance();
    }

    public LiveData<List<Track>> getTracks(){
        return trackRepository.getTracks();
    }
}
