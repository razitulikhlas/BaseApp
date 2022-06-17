package com.razit.baseapp.view;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.razit.baseapp.data.LocalResource;
import com.razit.baseapp.data.NetworkResource;
import com.razit.baseapp.data.RepositoryMovies;
import com.razit.baseapp.data.local.entity.Movies;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {
    RepositoryMovies repositoryMovies;


    public HomeViewModel(@NonNull Application application) {
        super(application);
        repositoryMovies = new RepositoryMovies(new LocalResource(application), new NetworkResource());
    }

    public LiveData<List<Movies>> getDataTeam() {
        return repositoryMovies.getDataFromDatabase();
    }

    public LiveData<String> message(){
        return repositoryMovies.getMessageLiveData();
    }

    public void getDataFromServer() {
        repositoryMovies.getServer();
    }

    public void update(Movies movies) {
        repositoryMovies.update(movies);
    }

    public void delete(Movies movies) {
        repositoryMovies.delete(movies);
    }


}
