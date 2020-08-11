package com.prography.playeasy.match.domain.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

//Match를 바로 DTO로 쓰기에는 "match "직렬화 하기 어려움
public class Match {
    @SerializedName("id")
    private int id;
    // private String title;
    //  static enum Type{SOCCER,FOOTSAL5,FOOTSAL6};
    @SerializedName("type")
    private String type;

    @SerializedName("description")
    private String description;

    @SerializedName("startAt")
    private Date startAt;
    //location 변수 대신 duration 넣음

    @SerializedName("duration")
    private int duration;

    @SerializedName("fee")
    private int fee;

    @SerializedName("phone")
    private String phone;

    @SerializedName("totalQuota")
    private int totalQuota;
    //static enum Status{WAITING,CONFIRMED,CANCEL};

    @SerializedName("status")
    private String status;
    @SerializedName("writerId")
    private int writerId;
    //사라진 필드 private int awayTeamId와 homeQuota;
    @SerializedName("homeTeam")
    private HomeTeamId homeTeam;
    @SerializedName("location")
    private LocationId location;

    public Match(int id, String type, String description, Date startAt, int duration, int fee, String phone, int totalQuota, String status, int writerId, HomeTeamId homeTeam, LocationId location) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.startAt = startAt;
        this.duration = duration;
        this.fee = fee;
        this.phone = phone;
        this.totalQuota = totalQuota;
        this.status = status;
        this.writerId = writerId;
        this.homeTeam = homeTeam;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getTotalQuota() {
        return totalQuota;
    }

    public void setTotalQuota(int totalQuota) {
        this.totalQuota = totalQuota;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getWriterId() {
        return writerId;
    }

    public void setWriterId(int writerId) {
        this.writerId = writerId;
    }

    public HomeTeamId getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(HomeTeamId homeTeam) {
        this.homeTeam = homeTeam;
    }

    public LocationId getLocation() {
        return location;
    }

    public void setLocation(LocationId location) {
        this.location = location;
    }
}
