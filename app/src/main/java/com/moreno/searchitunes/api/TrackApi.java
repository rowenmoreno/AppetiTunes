package com.moreno.searchitunes.api;

import com.moreno.searchitunes.api.responsemodel.TrackResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TrackApi {

    @GET("test")
    Call<TrackResponse> getTracks();

    
}