package com.oleeja.soccerinfo.data.api.mappers;

import com.oleeja.soccerinfo.data.api.dto.TeamDto;
import com.oleeja.soccerinfo.data.utils.Mapper;
import com.oleeja.soccerinfo.domain.teams.model.TeamModel;

import javax.inject.Inject;

/**
 * Created by Oleja on 01.02.2018.
 */

public class TeamResponseMapper implements Mapper<TeamDto, TeamModel> {

    @Inject
    TeamResponseMapper() {
        super();
    }

    @Override
    public TeamModel map(TeamDto teamDto) {
        return TeamModel.create(
                teamDto.name,
                teamDto.code,
                teamDto.shortName,
                teamDto.crestUrl);
    }
}
