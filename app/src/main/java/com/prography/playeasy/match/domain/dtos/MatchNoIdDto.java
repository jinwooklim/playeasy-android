package com.prography.playeasy.match.domain.dtos;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

//매치 작성 resquest
//@SerializedName("matchData")
public class MatchNoIdDto {
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
    //    @SerializedN
    @SerializedName("totalQuota")
    int totalQuota;

    @SerializedName("phone")
    private String phone;

    public MatchNoIdDto(String typ, String description, Date startAt, int duration, int fee, String phone, int totalQuota) {
        this.type = typ;
        this.description = description;
        this.startAt = startAt;
        this.duration = duration;
        this.fee = fee;
        this.phone = phone;
        this.totalQuota = totalQuota;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getTotalQuota() {
        return totalQuota;
    }

    public void setTotalQuota(int totalQuota) {
        this.totalQuota = totalQuota;
    }
}
