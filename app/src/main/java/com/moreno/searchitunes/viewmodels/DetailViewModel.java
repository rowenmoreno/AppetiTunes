package com.moreno.searchitunes.viewmodels;

import android.arch.lifecycle.ViewModel;

import com.moreno.searchitunes.models.Track;

public class DetailViewModel extends ViewModel {
    Track track;

    public void setTrack(Track track) {
        this.track = track;
    }

    public Track getTrack() {
        return track;
    }
}
