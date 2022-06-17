package com.razit.baseapp.data;

import androidx.annotation.NonNull;

import com.razit.baseapp.BuildConfig;
import com.razit.baseapp.data.network.Client;
import com.razit.baseapp.data.network.response.ResponseMovies;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkResource {
    public void getMovies(CallBackServer callBackServer) {
        Client.getAPI(BuildConfig.BASE_URL_MOVIES).getStanding(BuildConfig.API_KEY, "en-US", "1").enqueue(new Callback<ResponseMovies>() {
            @Override
            public void onResponse(@NonNull Call<ResponseMovies> call, @NonNull Response<ResponseMovies> response) {
                if (response.isSuccessful()) {
                   if((response.body() != null ? response.body().getResults() : null) != null){
                       callBackServer.getData(response.body().getResults());
                   }
                    
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseMovies> call, @NonNull Throwable t) {
                callBackServer.getMessage("exception " + t.getMessage());
            }
        });

    }
}
