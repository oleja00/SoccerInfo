package com.oleeja.soccerinfo.data.api.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ErrorDto {

    @SerializedName("error") @Expose public String error;

}