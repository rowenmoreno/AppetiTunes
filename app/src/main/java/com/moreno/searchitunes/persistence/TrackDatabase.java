package com.moreno.searchitunes.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.moreno.searchitunes.models.Track;

@Database(entities = {Track.class}, version =1)
public abstract class TrackDatabase extends RoomDatabase {

    private static TrackDatabase instance;

    private static final String DATABASE_NAME = "tracks_db";

    public static TrackDatabase getInstance(Context context) {
        if (instance == null)
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    TrackDatabase.class,
                    DATABASE_NAME)
                    .build();
        return instance;
    }

    public abstract TrackDao getTrackDao();
}
