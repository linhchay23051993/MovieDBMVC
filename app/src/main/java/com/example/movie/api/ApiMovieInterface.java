package com.example.movie.api;

import com.example.movie.entity.MovieResultsDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiMovieInterface {
    @GET("popular?")
    Call<MovieResultsDto> getPopularMovie(@Query("api_key") String apiKey, @Query("page") int page);
}
