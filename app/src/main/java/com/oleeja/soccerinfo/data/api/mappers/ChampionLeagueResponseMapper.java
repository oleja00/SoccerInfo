package com.oleeja.soccerinfo.data.api.mappers;

import com.oleeja.soccerinfo.data.api.dto.ChampionGroupDto;
import com.oleeja.soccerinfo.data.utils.Mapper;
import com.oleeja.soccerinfo.domain.leagues.model.ChampionGroupModel;

import javax.inject.Inject;

/**
 * Created by Oleja on 29.01.2018.
 */

public class ChampionLeagueResponseMapper implements Mapper<ChampionGroupDto, ChampionGroupModel> {

    @Inject
    ChampionLeagueResponseMapper() {
        super();
    }

    @Override
    public ChampionGroupModel map(ChampionGroupDto championGroupDto) {
        return ChampionGroupModel.create(
                championGroupDto.teamId,
                championGroupDto.team,
                championGroupDto.group,
                championGroupDto.crestURI);
    }
}
