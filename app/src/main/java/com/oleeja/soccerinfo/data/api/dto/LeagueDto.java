package com.oleeja.soccerinfo.data.api.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Oleja on 25.01.2018.
 */

public class LeagueDto {

    @SerializedName("id")
    public long id;

    @SerializedName("caption")
    public String caption;

    @SerializedName("league")
    public String league;

    @SerializedName("year")
    public String year;

    @SerializedName("currentMatchday")
    public long currentMatchday;

    @SerializedName("numberOfMatchdays")
    public long numberOfMatchdays;

    @SerializedName("numberOfTeams")
    public long numberOfTeams;

    @SerializedName("numberOfGames")
    public long numberOfGames;

    @SerializedName("lastUpdated")
    public String lastUpdated;

}
