package com.prography.playeasy.match.domain.dtos.response;

import com.google.gson.annotations.SerializedName;
import com.prography.playeasy.match.domain.models.Match;

public class MatchCreateResponseDto {

    @SerializedName("match")
    Match match;
}
