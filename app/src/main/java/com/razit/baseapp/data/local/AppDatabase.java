package com.razit.baseapp.data.local;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.razit.baseapp.data.local.dao.MoviesDao;
import com.razit.baseapp.data.local.entity.Movies;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Movies.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MoviesDao teamDao();

    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "user_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
