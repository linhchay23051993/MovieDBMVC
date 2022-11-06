package com.example.movie.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie.R;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new MovieViewHolder(inflater.inflate(R.layout.item_movie_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout movieItem;
        public ImageView favourite;
        public TextView title;
        public TextView rate;
        public TextView overview;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            movieItem = itemView.findViewById(R.id.movie_parent_layout);
            favourite = itemView.findViewById(R.id.favourite_movie);
            title = itemView.findViewById(R.id.title_movie);
            rate = itemView.findViewById(R.id.rate_movie);
            overview = itemView.findViewById(R.id.overview_movie);
        }
    }
}
