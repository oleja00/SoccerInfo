package com.oleeja.soccerinfo.data.api.mappers;

import com.oleeja.soccerinfo.data.api.dto.PlayerDto;
import com.oleeja.soccerinfo.data.api.responses.PlayersResponse;
import com.oleeja.soccerinfo.data.utils.Mapper;
import com.oleeja.soccerinfo.domain.teams.model.PlayerModel;

import javax.inject.Inject;

/**
 * Created by Oleja on 01.02.2018.
 */

public class PlayerResponseMapper implements Mapper<PlayerDto, PlayerModel>{

    @Inject
    PlayerResponseMapper() {
        super();
    }

    @Override
    public PlayerModel map(PlayerDto playerDto) {
        return PlayerModel.create(
                playerDto.name,
                playerDto.position,
                playerDto.jerseyNumber,
                playerDto.dateOfBirth,
                playerDto.nationality,
                playerDto.contractUntil);
    }
}
