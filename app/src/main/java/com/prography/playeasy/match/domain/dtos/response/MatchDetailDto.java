package com.prography.playeasy.match.domain.dtos.response;

import com.google.gson.annotations.SerializedName;
import com.prography.playeasy.match.domain.models.Match;

public class MatchDetailDto {

    @SerializedName("match")
    Match match;

    public Match getMatch() {

        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}
