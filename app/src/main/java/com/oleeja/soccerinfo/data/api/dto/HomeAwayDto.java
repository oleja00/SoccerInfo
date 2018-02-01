package com.oleeja.soccerinfo.data.api.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Oleja on 29.01.2018.
 */

public class HomeAwayDto {
    @SerializedName("goals")
    public long goals;

    @SerializedName("goalsAgainst")
    public long goalsAgainst;

    @SerializedName("wins")
    public long wins;

    @SerializedName("draws")
    public long draws;

    @SerializedName("losses")
    public long losses;

}
