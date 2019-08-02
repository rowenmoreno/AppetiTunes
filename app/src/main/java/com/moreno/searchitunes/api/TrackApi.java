package com.moreno.searchitunes.api;

import com.moreno.searchitunes.api.responsemodel.TrackListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TrackApi {

    @GET("search")
    Call<TrackListResponse> getTracks(
            @Query("term") String term,
            @Query("country") String country,
            @Query("media") String media);

    
}