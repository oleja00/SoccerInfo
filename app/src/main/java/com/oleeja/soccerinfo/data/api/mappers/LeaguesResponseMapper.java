package com.oleeja.soccerinfo.data.api.mappers;

import com.oleeja.soccerinfo.data.api.dto.LeagueDto;
import com.oleeja.soccerinfo.data.utils.Mapper;
import com.oleeja.soccerinfo.domain.leagues.model.LeagueModel;

import javax.inject.Inject;

/**
 * Created by Oleja on 27.01.2018.
 */

public class LeaguesResponseMapper implements Mapper<LeagueDto, LeagueModel> {

    @Inject
    LeaguesResponseMapper() {
        super();
    }

    @Override
    public LeagueModel map(LeagueDto leagueDto) {
        return LeagueModel.create(leagueDto.id,
                leagueDto.caption,
                leagueDto.league,
                leagueDto.year,
                leagueDto.currentMatchday,
                leagueDto.numberOfMatchdays,
                leagueDto.numberOfTeams,
                leagueDto.numberOfGames,
                leagueDto.lastUpdated);
    }
}
