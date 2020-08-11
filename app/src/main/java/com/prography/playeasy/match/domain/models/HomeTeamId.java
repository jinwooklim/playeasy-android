package com.prography.playeasy.match.domain.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class HomeTeamId {
    @SerializedName("id")
    int id;
    @SerializedName("name")
    String name;
    @SerializedName("description")
    String description;
    @SerializedName("age")
    int age;
    @SerializedName("level")
    String level;

    @SerializedName("leader")
    String leader;
    //phone Null가능하고
    @SerializedName("phone")
    String phone;


}
