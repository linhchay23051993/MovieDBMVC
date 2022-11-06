package com.example.movie.api;

import com.example.movie.entity.MovieResultsDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiMovieInterface {
    @GET("popular")
    Call<MovieResultsDto> getPopularMovie(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("top_rated")
    Call<MovieResultsDto> getTopRateMovie(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("upcoming")
    Call<MovieResultsDto> getUpcomingMovie(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("now_playing")
    Call<MovieResultsDto> getNowPlayingMovie(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("{id}/credits")
    Call<MovieResultsDto> getCastMovie(@Path("id") int id, @Query("api_key") String apiKey);
}
