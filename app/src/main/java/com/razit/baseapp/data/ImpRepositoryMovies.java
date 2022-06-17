package com.razit.baseapp.data;

import androidx.lifecycle.LiveData;

import com.razit.baseapp.data.local.entity.Movies;

import java.util.List;

public interface ImpRepositoryMovies {
    void update(Movies movies);

    void delete(Movies movies);

    void getServer();

    LiveData<List<Movies>> getDataFromDatabase();
}
