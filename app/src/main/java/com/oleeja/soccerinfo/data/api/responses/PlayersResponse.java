package com.oleeja.soccerinfo.data.api.responses;

import com.google.gson.annotations.SerializedName;
import com.oleeja.soccerinfo.data.api.dto.PlayerDto;

import java.util.List;

/**
 * Created by Oleja on 01.02.2018.
 */

public class PlayersResponse {

    @SerializedName("count")
    public long count;

    @SerializedName("players")
    public List<PlayerDto> players;
}
