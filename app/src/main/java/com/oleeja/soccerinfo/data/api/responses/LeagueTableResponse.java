package com.oleeja.soccerinfo.data.api.responses;

import com.google.gson.annotations.SerializedName;
import com.oleeja.soccerinfo.data.api.dto.StandingDto;

import java.util.List;

/**
 * Created by Oleja on 28.01.2018.
 */

public class LeagueTableResponse {

    @SerializedName("leagueCaption")
    public String leagueCaption;

    @SerializedName("matchday")
    public long matchday;

    @SerializedName("standing")
    public List<StandingDto> standing;
}
