package com.example.movie.entity;

import com.google.gson.annotations.SerializedName;

public class MovieListDto {
    @SerializedName("id")
    private int mId;

    @SerializedName("poster_path")
    private String mPosterPath;

    @SerializedName("overview")
    private String mOverview;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("vote_average")
    private String mVoteAverage;

    @SerializedName("release_date")
    private String mReleaseDate;

    public int getmId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public void setPosterPath(String mPosterPath) {
        this.mPosterPath = mPosterPath;
    }

    public String getOverview() {
        return mOverview;
    }

    public void setOverview(String mOverview) {
        this.mOverview = mOverview;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getVoteAverage() {
        return mVoteAverage;
    }

    public void setVoteAverage(String mVoteAverage) {
        this.mVoteAverage = mVoteAverage;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String mReleaseDate) {
        this.mReleaseDate = mReleaseDate;
    }
}
