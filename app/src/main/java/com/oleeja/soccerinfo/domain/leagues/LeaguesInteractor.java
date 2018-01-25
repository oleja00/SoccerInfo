package com.oleeja.soccerinfo.domain.leagues;

import com.oleeja.soccerinfo.data.leagues.LeaguesRepositoryImpl;

import javax.inject.Inject;

/**
 * Created by Oleja on 25.01.2018.
 */

public class LeaguesInteractor {
    private LeaguesRepository mLeaguesRepository;

    @Inject
    public LeaguesInteractor(LeaguesRepositoryImpl leaguesRepository) {
        mLeaguesRepository = leaguesRepository;
    }

}
