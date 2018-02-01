package com.oleeja.soccerinfo.data.api.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Oleja on 01.02.2018.
 */

public class PlayerDto {

    @SerializedName("name")
    public String name;

    @SerializedName("position")
    public String position;

    @SerializedName("jerseyNumber")
    public long jerseyNumber;

    @SerializedName("dateOfBirth")
    public String dateOfBirth;

    @SerializedName("nationality")
    public String nationality;

    @SerializedName("contractUntil")
    public String contractUntil;

}
