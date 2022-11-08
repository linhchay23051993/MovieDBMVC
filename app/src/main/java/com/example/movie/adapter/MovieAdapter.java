package com.example.movie.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie.GlobalConstants;
import com.example.movie.R;
import com.example.movie.entity.MovieListDto;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<MovieListDto> mMovieList;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    public MovieAdapter(Context context, View.OnClickListener onClickListener) {
        mContext = context;
        mOnClickListener = onClickListener;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new MovieViewHolder(inflater.inflate(R.layout.item_movie_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.title.setText(mMovieList.get(position).getTitle());
        holder.releaseDate.setText(mMovieList.get(position).getReleaseDate());
        holder.rate.setText(mMovieList.get(position).getVoteAverage());
        holder.overview.setText(mMovieList.get(position).getOverview());
        holder.progressBar.setVisibility(View.VISIBLE);

        holder.movieItem.setOnClickListener(mOnClickListener);
        holder.movieItem.setTag(mMovieList.get(position));
        Picasso.with(mContext).load(GlobalConstants.IMAGE_BASE_URL + mMovieList.get(position).getPosterPath()).into(holder.poster, new Callback() {
            @Override
            public void onSuccess() {
                holder.progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setMovieList(List<MovieListDto> movieList) {
        this.mMovieList = movieList;
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
