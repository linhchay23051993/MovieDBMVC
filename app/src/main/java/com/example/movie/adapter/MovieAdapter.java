package com.example.movie.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie.R;
import com.example.movie.entity.MovieListDto;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<MovieListDto> mMovieList;

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new MovieViewHolder(inflater.inflate(R.layout.item_movie_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.title.setText(mMovieList.get(position).getOverview());
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setMovieList(List<MovieListDto> mMovieList) {
        this.mMovieList = mMovieList;
        notifyDataSetChanged();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        public CardView movieItem;
        public ImageView favourite;
        public ImageView poster;
        public TextView title;
        public TextView rate;
        public TextView releaseDate;
        public TextView overview;
        public ProgressBar progressBar;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            movieItem = itemView.findViewById(R.id.movie_parent_layout);
            favourite = itemView.findViewById(R.id.favorite_imageview);
            poster = itemView.findViewById(R.id.poster_imageview);
            title = itemView.findViewById(R.id.title_textview);
            rate = itemView.findViewById(R.id.vote_average_textview);
            releaseDate = itemView.findViewById(R.id.release_date_textview);
            overview = itemView.findViewById(R.id.overview_textview);
            progressBar = itemView.findViewById(R.id.progress_bar);
        }
    }
}
