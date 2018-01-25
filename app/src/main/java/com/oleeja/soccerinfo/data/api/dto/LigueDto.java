package com.oleeja.soccerinfo.data.api.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Oleja on 25.01.2018.
 */

public class LigueDto {

    @SerializedName("id")
    private long id;

    @SerializedName("caption")
    private String caption;

    @SerializedName("league")
    private String league;

    @SerializedName("year")
    private String year;

    @SerializedName("currentMatchday")
    private long currentMatchday;

    @SerializedName("numberOfMatchdays")
    private long numberOfMatchdays;

    @SerializedName("numberOfTeams")
    private long numberOfTeams;

    @SerializedName("numberOfGames")
    private long numberOfGames;

    @SerializedName("lastUpdated")
    private String lastUpdated;

}
