package com.moreno.searchitunes.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static TrackApi getTrackApi(){
        return retrofit.create(TrackApi.class);
    }
}
