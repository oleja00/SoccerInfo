package com.oleeja.soccerinfo.data.leagues;

import com.oleeja.soccerinfo.data.api.RestApi;
import com.oleeja.soccerinfo.data.api.mappers.LeagueTableResponseMapper;
import com.oleeja.soccerinfo.data.api.mappers.LeaguesResponseMapper;
import com.oleeja.soccerinfo.data.utils.Mappers;
import com.oleeja.soccerinfo.domain.leagues.LeagueModel;
import com.oleeja.soccerinfo.domain.leagues.LeagueTableModel;
import com.oleeja.soccerinfo.domain.leagues.LeaguesRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Oleja on 25.01.2018.
 */

public class LeaguesRepositoryImpl implements LeaguesRepository {

    private RestApi mRestApi;
    private LeaguesResponseMapper mLeaguesResponseMapper;
    private LeagueTableResponseMapper mLeagueTableResponseMapper;

    @Inject
    public LeaguesRepositoryImpl(RestApi restApi,
                                 LeaguesResponseMapper leaguesResponseMapper,
                                 LeagueTableResponseMapper leagueTableResponseMapper){
        mRestApi = restApi;
        mLeaguesResponseMapper = leaguesResponseMapper;
        mLeagueTableResponseMapper = leagueTableResponseMapper;
    }


    @Override
    public Single<List<LeagueModel>> getLeagues() {
        return mRestApi.getLeagues().map(leagueDtoList -> Mappers.mapCollection(leagueDtoList, mLeaguesResponseMapper));
    }

    @Override
    public Single<LeagueModel> getLeague(long id) {
        return mRestApi.getLeague(id).map(mLeaguesResponseMapper::map);
    }

    @Override
    public Single<List<LeagueTableModel>> getLeagueTable(long id) {
        return mRestApi.getLeagueTable(id).map(
                leagueTableResponse -> Mappers.mapCollection(leagueTableResponse.standing, mLeagueTableResponseMapper));
    }
}
