package com.oleeja.soccerinfo.data.api.responses;

import com.google.gson.annotations.SerializedName;
import com.oleeja.soccerinfo.data.api.dto.StandingsDto;

/**
 * Created by Oleja on 31.01.2018.
 */

public class ChampionLigueResponse {
    @SerializedName("leagueCaption")
    public String leagueCaption;

    @SerializedName("matchday")
    public long matchday;

    @SerializedName("standings")
    public StandingsDto standings;
}
