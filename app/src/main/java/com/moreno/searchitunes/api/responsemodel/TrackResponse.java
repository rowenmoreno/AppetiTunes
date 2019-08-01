package com.moreno.searchitunes.api.responsemodel;

import com.moreno.searchitunes.models.Track;

import java.util.ArrayList;
import java.util.List;

public class TrackResponse {
    List<Track> tracks = new ArrayList<>();

    public List<Track> getTracks() {
        return tracks;
    }
}
