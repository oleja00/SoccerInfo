package com.oleeja.soccerinfo.data.api.mappers;

import com.oleeja.soccerinfo.data.api.dto.StandingsDto;
import com.oleeja.soccerinfo.data.utils.Mapper;
import com.oleeja.soccerinfo.data.utils.Mappers;
import com.oleeja.soccerinfo.domain.leagues.ChampionGroupModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Oleja on 29.01.2018.
 */

public class ChampionLeagueTableResponseMapper implements Mapper<StandingsDto, List<List<ChampionGroupModel>>> {

    private ChampionLeagueResponseMapper mChampionLeagueResponseMapper;
    @Inject
    ChampionLeagueTableResponseMapper(ChampionLeagueResponseMapper championLeagueResponseMapper) {
        super();
        mChampionLeagueResponseMapper = championLeagueResponseMapper;
    }

    @Override
    public List<List<ChampionGroupModel>> map(StandingsDto standingsDto) {
        List<List<ChampionGroupModel>>  championGroup = new ArrayList<>();
        championGroup.add(Mappers.mapCollection(standingsDto.a, mChampionLeagueResponseMapper));
        championGroup.add(Mappers.mapCollection(standingsDto.b, mChampionLeagueResponseMapper));
        championGroup.add(Mappers.mapCollection(standingsDto.c, mChampionLeagueResponseMapper));
        championGroup.add(Mappers.mapCollection(standingsDto.d, mChampionLeagueResponseMapper));
        championGroup.add(Mappers.mapCollection(standingsDto.e, mChampionLeagueResponseMapper));
        championGroup.add(Mappers.mapCollection(standingsDto.f, mChampionLeagueResponseMapper));
        championGroup.add(Mappers.mapCollection(standingsDto.g, mChampionLeagueResponseMapper));
        championGroup.add(Mappers.mapCollection(standingsDto.h, mChampionLeagueResponseMapper));
        return championGroup;

    }
}
