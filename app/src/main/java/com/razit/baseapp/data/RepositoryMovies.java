package com.razit.baseapp.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.razit.baseapp.data.local.entity.Movies;
import com.razit.baseapp.data.network.response.ResultsItem;
import com.razit.baseapp.util.MappingData;

import java.util.List;

public class RepositoryMovies implements ImpRepositoryMovies {
    private final LocalResource localResource;
    private final NetworkResource networkResource;
    MutableLiveData<String> messageLiveData;

    public MutableLiveData<String> getMessageLiveData() {
        return messageLiveData;
    }

    public RepositoryMovies(LocalResource localResource, NetworkResource networkResource) {
        this.localResource = localResource;
        this.networkResource = networkResource;
        messageLiveData = new MutableLiveData<>();
    }

    @Override
    public void update(Movies movies) {
        localResource.update(movies);
    }

    @Override
    public void delete(Movies movies) {
        localResource.delete(movies);
    }

    @Override
    public LiveData<List<Movies>> getDataFromDatabase() {
        return localResource.getAllUsers();
    }

    public void getServer() {
        networkResource.getMovies(new CallBackServer() {
            @Override
            public void getData(List<ResultsItem> lisMovies) {
                List<Movies> moviesList = MappingData.mapListResponseStandingToListMovies(lisMovies);
                localResource.insertAll(moviesList);
            }

            @Override
            public void getMessage(String message) {

            }
        });
    }


}
