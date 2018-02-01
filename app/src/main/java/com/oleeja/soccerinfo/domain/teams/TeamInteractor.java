package com.oleeja.soccerinfo.domain.teams;

import com.oleeja.soccerinfo.data.leagues.TeamRepositoryImpl;
import com.oleeja.soccerinfo.domain.teams.model.TeamModel;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by Oleja on 01.02.2018.
 */

public class TeamInteractor {
    private TeamRepository mTeamRepository;

    @Inject
    public TeamInteractor(TeamRepositoryImpl teamRepository) {
        mTeamRepository = teamRepository;
    }

    public Single<TeamModel> getTeam(long id){
        return mTeamRepository.getTeam(id)
                .flatMap(teamModel -> mTeamRepository.getPlayers(id)
                        .flatMap(playerModels -> {
                            teamModel.addPlayers(playerModels);
                            return Single.just(teamModel);
                        }));

    }
}
