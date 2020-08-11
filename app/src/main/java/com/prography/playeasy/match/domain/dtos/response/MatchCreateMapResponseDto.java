package com.prography.playeasy.match.domain.dtos.response;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;

public class MatchCreateMapResponseDto {
    @SerializedName("address_name")
    String address_name;
    @SerializedName("category_group_code")
    String category_group_code;
    @SerializedName("category_group_name")
    String category_group_name;
    @SerializedName("category_name")
    String category_name;

    @SerializedName("id")
    int id;
    @SerializedName("phone")
    String phone;
    @SerializedName("place_name")
    String place_name;
    @SerializedName("place_url")
    String place_url;
    @SerializedName("road_address_name")
    String road_address_name;

    @SerializedName("x")
    double x;
    @SerializedName("y")
    double y;

    public String getAddress_name() {
        return address_name;
    }

    public void setAddress_name(String address_name) {
        this.address_name = address_name;
    }

    public String getCategory_group_code() {
        return category_group_code;
    }

    public void setCategory_group_code(String category_group_code) {
        this.category_group_code = category_group_code;
    }

    public String getCategory_group_name() {
        return category_group_name;
    }

    public void setCategory_group_name(String category_group_name) {
        this.category_group_name = category_group_name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public String getPlace_url() {
        return place_url;
    }

    public void setPlace_url(String place_url) {
        this.place_url = place_url;
    }

    public String getRoad_address_name() {
        return road_address_name;
    }

    public void setRoad_address_name(String road_address_name) {
        this.road_address_name = road_address_name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
