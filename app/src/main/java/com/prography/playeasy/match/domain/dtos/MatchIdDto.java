package com.prography.playeasy.match.domain.dtos;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class MatchIdDto {
    @SerializedName("id")
    int id;
    @SerializedName("type")
    String type;
    @SerializedName("description")
    private String description;

    @SerializedName("startAt")
    private Date startAt;
    //location 변수 대신 duration 넣음
    @SerializedName("duration")
    private int duration;
    @SerializedName("fee")
    private int fee;
    //@SerializedN
    @SerializedName("totalQuota")
    int totalQuota;


}
