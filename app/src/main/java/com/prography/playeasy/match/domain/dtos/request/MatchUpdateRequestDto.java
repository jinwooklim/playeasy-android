package com.prography.playeasy.match.domain.dtos.request;

import com.google.gson.annotations.SerializedName;
import com.prography.playeasy.match.domain.dtos.MatchIdDto;
import com.prography.playeasy.match.domain.models.LocationId;
import com.prography.playeasy.match.domain.models.Match;

//완성
public class MatchUpdateRequestDto {
    @SerializedName("matchId")
    int matchId;
    //critical fix
    @SerializedName("matchData")
    MatchIdDto matchData;
    @SerializedName("locationData")
    LocationId locationData;

    public MatchUpdateRequestDto(int matchId, MatchIdDto matchData, LocationId locationData) {
        this.matchId = matchId;
        this.matchData = matchData;
        this.locationData = locationData;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public MatchIdDto getMatchData() {
        return matchData;
    }

    public void setMatchData(MatchIdDto matchData) {
        this.matchData = matchData;
    }

    public LocationId getLocationData() {
        return locationData;
    }

    public void setLocationData(LocationId locationData) {
        this.locationData = locationData;
    }
}
