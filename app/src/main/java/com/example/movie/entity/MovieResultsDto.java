package com.example.movie.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResultsDto {
    @SerializedName("results")
    private List<MovieListDto> mResultsDtoList;

    public List<MovieListDto> getResultsDtoList() {
        return mResultsDtoList;
    }

    public void setResultsDtoList(List<MovieListDto> mResultsDtoList) {
        this.mResultsDtoList = mResultsDtoList;
    }
}
