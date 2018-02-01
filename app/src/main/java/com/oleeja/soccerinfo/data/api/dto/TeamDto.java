package com.oleeja.soccerinfo.data.api.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Oleja on 01.02.2018.
 */

public class TeamDto {
    @SerializedName("name")
    public String name;

    @SerializedName("code")
    public String code;

    @SerializedName("shortName")
    public String shortName;

    @SerializedName("crestUrl")
    public String crestUrl;

}
