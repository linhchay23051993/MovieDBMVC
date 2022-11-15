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

public class MovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MovieListDto> mMovieList;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private int mViewType;

    public MovieAdapter(Context context, View.OnClickListener onClickListener, int viewType) {
        mContext = context;
        mOnClickListener = onClickListener;
        mViewType = viewType;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (mViewType == 1) {
            return new MovieViewHolder(inflater.inflate(R.layout.item_movie_layout, parent, false));
        } else if (mViewType == 2) {
            return new MovieGridViewHolder(inflater.inflate(R.layout.item_movie_grid_layout, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (mViewType == 1) {
            MovieViewHolder movieViewHolder = (MovieViewHolder) holder;
            movieViewHolder.title.setText(mMovieList.get(position).getTitle());
            movieViewHolder.releaseDate.setText(mMovieList.get(position).getReleaseDate());
            movieViewHolder.rate.setText(mMovieList.get(position).getVoteAverage());
            movieViewHolder.overview.setText(mMovieList.get(position).getOverview());
            movieViewHolder.progressBar.setVisibility(View.VISIBLE);

            movieViewHolder.movieItem.setOnClickListener(mOnClickListener);
            movieViewHolder.movieItem.setTag(mMovieList.get(position));
            Picasso.with(mContext).load(GlobalConstants.IMAGE_BASE_URL + mMovieList.get(position).getPosterPath()).into(movieViewHolder.poster, new Callback() {
                @Override
                public void onSuccess() {
                    movieViewHolder.progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onError() {

                }
            });
        } else if (mViewType == 2) {
            MovieGridViewHolder gridViewHolder = (MovieGridViewHolder) holder;
            gridViewHolder.title.setText(mMovieList.get(position).getTitle());
            gridViewHolder.progressBar.setVisibility(View.VISIBLE);
            Picasso.with(mContext).load(GlobalConstants.IMAGE_BASE_URL + mMovieList.get(position).getPosterPath()).into(gridViewHolder.poster, new Callback() {
                @Override
                public void onSuccess() {
                    gridViewHolder.progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onError() {

                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
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

    public static class MovieGridViewHolder extends RecyclerView.ViewHolder {
        public CardView movieItem;
        public ImageView poster;
        public TextView title;
        public ProgressBar progressBar;

        public MovieGridViewHolder(@NonNull View itemView) {
            super(itemView);
            movieItem = itemView.findViewById(R.id.movie_parent_layout_grid);
            poster = itemView.findViewById(R.id.poster_imageview_grid);
            title = itemView.findViewById(R.id.title_textview_grid);
            progressBar = itemView.findViewById(R.id.progress_bar_grid);
        }
    }
}
