package com.razit.baseapp.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.razit.baseapp.data.local.AppDatabase;
import com.razit.baseapp.data.local.dao.MoviesDao;
import com.razit.baseapp.data.local.entity.Movies;

import java.util.List;

public class LocalResource {
    private final MoviesDao moviesDao;
    private final LiveData<List<Movies>> allMovies;

    public LocalResource(Application application){
        AppDatabase database = AppDatabase.getDatabase(application);
        moviesDao = database.teamDao();
        allMovies = moviesDao.getAll();
    }

    LiveData<List<Movies>> getAllUsers(){
        return allMovies;
    }

    void insertAll(List<Movies> moviesList){
        AppDatabase.databaseWriteExecutor.execute(() -> moviesDao.insertAll(moviesList));
    }

    void update(Movies movies){
        AppDatabase.databaseWriteExecutor.execute(() -> moviesDao.update(movies));
    }

    void delete(Movies movies){
        AppDatabase.databaseWriteExecutor.execute(() -> moviesDao.delete(movies));
    }
}
