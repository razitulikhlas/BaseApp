package com.razit.baseapp.data.local.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Movies {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "image")
    String image;

    @ColumnInfo(name = "name_movies")
    String nameMovies;

    @ColumnInfo(name = "release")
    String release;

    public Movies(String image, String nameMovies, String release) {
        this.image = image;
        this.nameMovies = nameMovies;
        this.release = release;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNameMovies() {
        return nameMovies;
    }

    public void setNameMovies(String nameMovies) {
        this.nameMovies = nameMovies;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }
}
