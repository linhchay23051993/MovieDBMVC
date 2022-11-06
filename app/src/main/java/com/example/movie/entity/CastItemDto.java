package com.example.movie.entity;

import com.google.gson.annotations.SerializedName;

public class CastItemDto {
    @SerializedName("release_date")
    private int mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("profile_path")
    private String mProfilePath;

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getProfilePath() {
        return mProfilePath;
    }

    public void setProfilePath(String mProfilePath) {
        this.mProfilePath = mProfilePath;
    }
}
