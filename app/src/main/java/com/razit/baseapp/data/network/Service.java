package com.razit.baseapp.data.network;

import com.razit.baseapp.data.network.response.ResponseMovies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface Service {

    @GET("movie/now_playing")
    Call<ResponseMovies> getStanding(
            @Query("api_key") String api_key,
            @Query("language") String language,
            @Query("page") String page
            );

}
