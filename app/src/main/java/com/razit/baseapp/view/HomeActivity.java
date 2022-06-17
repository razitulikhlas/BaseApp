package com.razit.baseapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.razit.baseapp.R;
import com.razit.baseapp.adapter.MoviesAdapter;

public class HomeActivity extends AppCompatActivity {
    HomeViewModel homeViewModel;
    RecyclerView recyclerView;
    MoviesAdapter moviesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.rcv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        moviesAdapter = new MoviesAdapter(this);
        homeViewModel = new ViewModelProvider(HomeActivity.this).get(HomeViewModel.class);
        homeViewModel.getDataTeam().observe(this, moviesList -> {
            if (moviesList.size() <= 0) {
                homeViewModel.getDataFromServer();
            }
            moviesAdapter.setMoviesList(moviesList);
            recyclerView.setAdapter(moviesAdapter);
            Log.e("TAG", "onCreateActivity: " + moviesList.size());
        });

        homeViewModel.message().observe(this, s -> {
            if (!s.isEmpty()) {
                Toast.makeText(this, s, Toast.LENGTH_LONG).show();
                Log.e("TAG", "onCreate: " + s);
            }
        });
    }
}