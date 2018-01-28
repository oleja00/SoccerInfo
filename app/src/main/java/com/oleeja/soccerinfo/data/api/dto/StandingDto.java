package com.oleeja.soccerinfo.data.api.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Oleja on 28.01.2018.
 */

public class StandingDto {
    @SerializedName("_links")
    private LinksDto links;

    @SerializedName("position")
    private long position;

    @SerializedName("teamName")
    private String teamName;

    @SerializedName("crestURI")
    private Object crestURI;

    @SerializedName("playedGames")
    private long playedGames;

    @SerializedName("points")
    private long points;

    @SerializedName("goals")
    private long goals;

    @SerializedName("goalsAgainst")
    private long goalsAgainst;

    @SerializedName("goalDifference")
    private long goalDifference;

    @SerializedName("wins")
    private long wins;

    @SerializedName("draws")
    private long draws;

    @SerializedName("losses")
    private long losses;

    @SerializedName("home")
    private HomeAwayDto home;

    @SerializedName("away")
    private HomeAwayDto away;

}
