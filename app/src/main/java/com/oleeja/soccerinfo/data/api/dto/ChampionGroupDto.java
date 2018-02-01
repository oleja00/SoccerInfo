package com.oleeja.soccerinfo.data.api.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Oleja on 31.01.2018.
 */

public class ChampionGroupDto {

    @SerializedName("group")
    public String group;

    @SerializedName("rank")
    public long rank;

    @SerializedName("team")
    public String team;

    @SerializedName("teamId")
    public long teamId;

    @SerializedName("playedGames")
    public long playedGames;

    @SerializedName("crestURI")
    public String crestURI;

    @SerializedName("points")
    public long points;

    @SerializedName("goals")
    public long goals;

    @SerializedName("goalsAgainst")
    public long goalsAgainst;

    @SerializedName("goalDifference")
    public long goalDifference;

}

