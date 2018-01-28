package com.oleeja.soccerinfo.domain.leagues;

import com.oleeja.soccerinfo.data.leagues.LeaguesRepositoryImpl;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Oleja on 25.01.2018.
 */

public class LeaguesInteractor {
    private LeaguesRepository mLeaguesRepository;

    @Inject
    public LeaguesInteractor(LeaguesRepositoryImpl leaguesRepository) {
        mLeaguesRepository = leaguesRepository;
    }

    public Single<List<LeagueModel>> getLeagues(){
        return mLeaguesRepository.getLeagues();
    }

    public Single<LeagueModel> getLeague(long id) {
        return mLeaguesRepository.getLeague(id);
    }
}
