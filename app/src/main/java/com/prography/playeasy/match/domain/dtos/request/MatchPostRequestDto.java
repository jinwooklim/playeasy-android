package com.prography.playeasy.match.domain.dtos.request;

import com.google.gson.annotations.SerializedName;
import com.prography.playeasy.match.domain.dtos.LocationDto;
import com.prography.playeasy.match.domain.dtos.MatchIdDto;
import com.prography.playeasy.match.domain.dtos.MatchNoIdDto;

import java.util.HashMap;

public class MatchPostRequestDto {
    @SerializedName("matchData")
    MatchNoIdDto matchData;
    //id없는 매치는 match
    @SerializedName("locatioinData")
    LocationDto locationData;


    public MatchPostRequestDto(MatchNoIdDto matchDto, LocationDto locationDto) {
        this.locationData = locationDto;
        this.matchData = matchDto;
    }

    public String toString() {
        return "MatchPostRequestDto{" +

                ", matchData=" + matchData +
                ", locationData='" + locationData + '\'' +
                '}';

    }

    public MatchNoIdDto getMatchData() {
        return matchData;
    }

    public void setMatchData(MatchNoIdDto matchData) {
        this.matchData = matchData;
    }

    public LocationDto getLocationData() {
        return locationData;
    }

    public void setLocationData(LocationDto locationData) {
        this.locationData = locationData;
    }
}
