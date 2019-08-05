package com.moreno.searchitunes.models;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

@Entity(tableName = "tracks")
public class Track implements Serializable {

    @PrimaryKey
    @NonNull
    private long trackId;

    public String trackName;
    public String artworkUrl100;
    public String trackPrice;
    public String primaryGenreName;
    public long trackDuration = 0L;
    public String longDescription;

    @NonNull
    public long getTrackId() {
        return trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public String getTrackPrice() {
        return trackPrice;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public long getTrackDuration() {
        return trackDuration;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setTrackId(@NonNull long trackId) {
        this.trackId = trackId;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public void setArtworkUrl100(String trackArtwork) {
        this.artworkUrl100 = trackArtwork;
    }

    public void setTrackPrice(String trackPrice) {
        this.trackPrice = trackPrice;
    }

    public void setPrimaryGenreName(String trackGenre) {
        this.primaryGenreName = trackGenre;
    }

    public void setTrackDuration(long trackDuration) {
        this.trackDuration = trackDuration;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }
}
