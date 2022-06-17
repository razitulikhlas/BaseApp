package com.razit.baseapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.razit.baseapp.BuildConfig;
import com.razit.baseapp.R;
import com.razit.baseapp.data.local.entity.Movies;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    List<Movies> moviesList;
    Context context;

    public MoviesAdapter(Context context) {
        this.context = context;
    }

    public void setMoviesList(List<Movies> moviesList) {
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_team,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movies movies = moviesList.get(position);
        holder.tvDate.setText(movies.getRelease());
        holder.tvTitle.setText(movies.getNameMovies());
        holder.tvRating.setText(String.valueOf((position+1)));
        Glide.with(context)
                .load(BuildConfig.IMAGES_URL+movies.getImage())
                .centerCrop()
                .into(holder.logoTeam);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle,tvDate,tvRating;
        ImageView logoTeam;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvRating = itemView.findViewById(R.id.tvRating);
            logoTeam = itemView.findViewById(R.id.imgPoster);
        }
    }
}
