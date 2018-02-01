package com.oleeja.soccerinfo.data.api.mappers;

import com.oleeja.soccerinfo.data.api.dto.StandingDto;
import com.oleeja.soccerinfo.data.utils.Mapper;
import com.oleeja.soccerinfo.domain.leagues.model.LeagueTableModel;

import javax.inject.Inject;

/**
 * Created by Oleja on 29.01.2018.
 */

public class LeagueTableResponseMapper implements Mapper<StandingDto, LeagueTableModel> {

    @Inject
    LeagueTableResponseMapper() {
        super();
    }

    @Override
    public LeagueTableModel map(StandingDto standingDto) {
        return LeagueTableModel.create(
                Long.parseLong(
                        standingDto.links.team.href.substring(standingDto.links.team.href.lastIndexOf("/")+1)),
                standingDto.position,
                standingDto.teamName,
                standingDto.crestURI,
                standingDto.playedGames,
                standingDto.points,
                standingDto.goals,
                standingDto.goalsAgainst,
                standingDto.goalDifference,
                standingDto.wins,
                standingDto.draws,
                standingDto.losses);
    }
}
