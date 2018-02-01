package com.oleeja.soccerinfo.data.leagues;

import com.oleeja.soccerinfo.data.api.RestApi;
import com.oleeja.soccerinfo.data.api.mappers.PlayerResponseMapper;
import com.oleeja.soccerinfo.data.api.mappers.TeamResponseMapper;
import com.oleeja.soccerinfo.data.utils.Mappers;
import com.oleeja.soccerinfo.domain.teams.TeamRepository;
import com.oleeja.soccerinfo.domain.teams.model.PlayerModel;
import com.oleeja.soccerinfo.domain.teams.model.TeamModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Oleja on 01.02.2018.
 */

public class TeamRepositoryImpl implements TeamRepository {
    private RestApi mRestApi;
    private PlayerResponseMapper mPlayerResponseMapper;
    private TeamResponseMapper mTeamResponseMapper;


    @Inject
    public TeamRepositoryImpl(RestApi restApi,
                              PlayerResponseMapper playerResponseMapper,
                              TeamResponseMapper teamResponseMapper){
        mRestApi = restApi;
        mPlayerResponseMapper = playerResponseMapper;
        mTeamResponseMapper = teamResponseMapper;
    }
    @Override
    public Single<TeamModel> getTeam(long id) {
        return mRestApi.getTeam(id).map(mTeamResponseMapper::map);
    }

    @Override
    public Single<List<PlayerModel>> getPlayers(long id) {
        return mRestApi.getPlayers(id)
                .map(playersResponse -> Mappers.mapCollection(playersResponse.players, mPlayerResponseMapper));
    }
}
