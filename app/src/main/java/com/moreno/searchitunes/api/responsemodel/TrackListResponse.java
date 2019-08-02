package com.moreno.searchitunes.api.responsemodel;

import com.google.gson.annotations.SerializedName;
import com.moreno.searchitunes.models.Track;

import java.util.ArrayList;
import java.util.List;

public class TrackListResponse {

    @SerializedName("resultCount")
    Integer resultCount;

    @SerializedName("results")
    List<Track> tracks = new ArrayList<>();

    public List<Track> getTracks() {
        return tracks;
    }

    public Integer getResultCount() {
        return resultCount;
    }
}
