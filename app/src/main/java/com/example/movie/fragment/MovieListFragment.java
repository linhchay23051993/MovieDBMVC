package com.example.movie.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie.GlobalConstants;
import com.example.movie.R;
import com.example.movie.adapter.MovieAdapter;
import com.example.movie.api.ApiClient;
import com.example.movie.entity.MovieListDto;
import com.example.movie.entity.MovieResultsDto;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private MovieAdapter mAdapter;

    private List<MovieListDto> mMovieListDto;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.movie_list_fragment_layout, container, false);

        mRecyclerView = view.findViewById(R.id.recycler_list_movie);
        mAdapter = new MovieAdapter(getContext());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        getMovieListFromAPI();
        return view;
    }

    private void getMovieListFromAPI() {
        ApiClient.getClient().getPopularMovie(GlobalConstants.API_KEY, 1).enqueue(new Callback<MovieResultsDto>() {
            @Override
            public void onResponse(Call<MovieResultsDto> call, Response<MovieResultsDto> response) {
                mMovieListDto = new ArrayList<>();
                mMovieListDto = response.body().getResultsDtoList();
                mAdapter.setMovieList(mMovieListDto);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<MovieResultsDto> call, Throwable t) {

            }
        });
    }
}
