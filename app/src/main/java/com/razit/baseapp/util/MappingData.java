package com.razit.baseapp.util;

import android.os.Build;

import com.razit.baseapp.data.local.entity.Movies;
import com.razit.baseapp.data.network.response.ResultsItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MappingData {
    public static List<Movies> mapListResponseStandingToListMovies(List<ResultsItem> resultsItems) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return resultsItems.stream()
                    .map(result -> new Movies(result.getBackdropPath(), result.getTitle(), result.getReleaseDate()))
                    .collect(Collectors.toList());
        } else {
            List<Movies> moviesList = new ArrayList<>();
            Movies movies;
            for(ResultsItem resultsItem: resultsItems) {
               movies = new Movies(resultsItem.getBackdropPath(), resultsItem.getTitle(),resultsItem.getReleaseDate());
               moviesList.add(movies);
            }
            return moviesList;
        }
    }
}
