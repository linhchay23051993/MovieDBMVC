package com.example.movie.api;

import com.example.movie.entity.MovieListDto;
import com.example.movie.entity.MovieResultsDto;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiMovieInterface {
    @GET("popular?api_key=0d677b16a44d2b5a79edf325bc1ee9b7")
    Call<MovieResultsDto> getListMovie();
}
