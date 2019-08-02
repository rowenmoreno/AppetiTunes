package com.moreno.searchitunes.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    private static String BASE_URL = "https://itunes.apple.com/";

    private static TrackApi trackApi = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TrackApi.class);

    public static TrackApi getTrackApi(){
        return trackApi;
    }
}
