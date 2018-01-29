package com.oleeja.soccerinfo.data.api.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Oleja on 28.01.2018.
 */

public class StandingDto {
    @SerializedName("_links")
    public LinksDto links;

    @SerializedName("position")
    public long position;

    @SerializedName("teamName")
    public String teamName;

    @SerializedName("crestURI")
    public String crestURI;

    @SerializedName("playedGames")
    public long playedGames;

    @SerializedName("points")
    public long points;

    @SerializedName("goals")
    public long goals;

    @SerializedName("goalsAgainst")
    public long goalsAgainst;

    @SerializedName("goalDifference")
    public long goalDifference;

    @SerializedName("wins")
    public long wins;

    @SerializedName("draws")
    public long draws;

    @SerializedName("losses")
    public long losses;

    @SerializedName("home")
    public HomeAwayDto home;

    @SerializedName("away")
    public HomeAwayDto away;

}
