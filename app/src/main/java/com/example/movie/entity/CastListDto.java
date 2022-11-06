package com.example.movie.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CastListDto {
    @SerializedName("id")
    private int mId;

    @SerializedName("cast")
    private List<CastItemDto> mCastItemDto;

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public List<CastItemDto> getCastItemDto() {
        return mCastItemDto;
    }

    public void setCastItemDto(List<CastItemDto> mCastItemDto) {
        this.mCastItemDto = mCastItemDto;
    }
}
