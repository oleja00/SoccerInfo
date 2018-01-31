package com.oleeja.soccerinfo.data.api.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Oleja on 31.01.2018.
 */

public class StandingsDto {

    @SerializedName("A")
    public List<ChampionGroupDto> a;

    @SerializedName("B")
    public List<ChampionGroupDto> b;

    @SerializedName("C")
    public List<ChampionGroupDto> c;

    @SerializedName("D")
    public List<ChampionGroupDto> d;

    @SerializedName("E")
    public List<ChampionGroupDto> e;

    @SerializedName("F")
    public List<ChampionGroupDto> f;

    @SerializedName("G")
    public List<ChampionGroupDto> g;

    @SerializedName("H")
    public List<ChampionGroupDto> h;
}
