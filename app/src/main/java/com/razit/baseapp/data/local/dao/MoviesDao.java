package com.razit.baseapp.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.razit.baseapp.data.local.entity.Movies;

import java.util.List;

@Dao
public interface MoviesDao {
    @Query("SELECT * FROM Movies")
    LiveData<List<Movies>> getAll();

    @Insert
    void insertAll(List<Movies> movies);

    @Update
    void update(Movies movies);

    @Delete
    void delete(Movies movies);
}
