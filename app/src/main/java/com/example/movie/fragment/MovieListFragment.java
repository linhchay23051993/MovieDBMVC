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

import com.example.movie.R;
import com.example.movie.adapter.MovieAdapter;
import com.example.movie.entity.MovieListDto;

import java.util.ArrayList;
import java.util.List;

public class MovieListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private MovieAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.movie_list_fragment_layout, container, false);

        mRecyclerView = view.findViewById(R.id.recycler_list_movie);
        mAdapter = new MovieAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<MovieListDto> mMovieList = new ArrayList<>();
        mMovieList.add(new MovieListDto(11, "22", "33", "44", "55", "66"));
        mMovieList.add(new MovieListDto(11, "22", "33", "44", "55", "66"));
        mAdapter.setMovieList(mMovieList);
        return view;
    }
}
