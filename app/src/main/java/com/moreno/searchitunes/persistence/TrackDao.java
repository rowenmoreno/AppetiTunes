package com.moreno.searchitunes.persistence;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.moreno.searchitunes.models.Track;

import java.util.List;


@Dao
public interface TrackDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertTrack(Track tracks);

    @Query("SELECT * FROM tracks")
    LiveData<List<Track>> getTracks();
}
