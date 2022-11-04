package com.example.movie.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit mRetrofit = null;

    public static ApiMovieInterface getClient() {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder().baseUrl("http://api.themoviedb.org/3/movie/").addConverterFactory(GsonConverterFactory.create()).build();
        }

        return mRetrofit.create(ApiMovieInterface.class);
    }
}
