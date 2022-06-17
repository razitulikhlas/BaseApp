package com.razit.baseapp.data;

import com.razit.baseapp.data.network.response.ResultsItem;

import java.util.List;

public interface CallBackServer {
    void getData(List<ResultsItem> lisMovies);

    void getMessage(String message);
}
