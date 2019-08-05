package com.moreno.searchitunes.repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.moreno.searchitunes.AppExecutor;
import com.moreno.searchitunes.api.Api;
import com.moreno.searchitunes.api.responsemodel.TrackListResponse;
import com.moreno.searchitunes.models.Track;
import com.moreno.searchitunes.persistence.TrackDao;
import com.moreno.searchitunes.persistence.TrackDatabase;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
*  TrackRepository is responsible for fetching data
*  from API or local database. In my case, I also added the handling of
*  SharedPreferences here.
* */
public class TrackRepository {

    private static TrackRepository instance;
    private MediatorLiveData<List<Track>> trackList = new MediatorLiveData<>();
    private TrackDao trackDao;
    private AppExecutor appExecutors;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    public static TrackRepository getInstance(Context context){
        if (instance == null)
            instance = new TrackRepository(context);
        return instance;
    }

    private TrackRepository(Context context){
        trackDao = TrackDatabase.getInstance(context).getTrackDao();
        appExecutors = AppExecutor.getInstance();
        sharedPreferences = context.getSharedPreferences(context.getPackageName(),Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        init();
    }

    public void save(String key, long value){
        editor.putLong(key, value);
        editor.commit();
    }

    public long get(String key){
        long value = sharedPreferences.getLong(key,0L);
        return value;
    }


    public LiveData<List<Track>> getTracks(){
        return trackList;
    }

    public void getTracksFromApiOrDb(final LiveData<List<Track>> fromDB){
        // 2. Fetch data from api
        Api.getTrackApi().getTracks("star","au", "movie").enqueue(new Callback<TrackListResponse>() {
            @Override
            public void onResponse(Call<TrackListResponse> call, final Response<TrackListResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    appExecutors.diskIO().execute(new Runnable() {
                        @Override
                        public void run() {
                            // 3. Insert response to database
                            for (Track t : response.body().getTracks())
                                trackDao.insertTrack(t);
                        }
                    });

                }
            }

            @Override
            public void onFailure(Call<TrackListResponse> call, Throwable t) {

            }
        });

    }

    private LiveData<List<Track>> loadFromDb() {
        return trackDao.getTracks();
    }

    private void init() {
        // 1. Load data from db
        final LiveData<List<Track>> fromDB = loadFromDb();
        trackList.addSource(fromDB, new Observer<List<Track>>() {
            @Override
            public void onChanged(@Nullable List<Track> tracks) {
                trackList.setValue(tracks);
                getTracksFromApiOrDb(fromDB);
            }
        });
    }



}
