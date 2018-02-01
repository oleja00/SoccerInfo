package com.oleeja.soccerinfo.domain.leagues;

import com.oleeja.soccerinfo.data.leagues.LeaguesRepositoryImpl;
import com.oleeja.soccerinfo.domain.leagues.model.ChampionGroupModel;
import com.oleeja.soccerinfo.domain.leagues.model.LeagueModel;
import com.oleeja.soccerinfo.domain.leagues.model.LeagueTableModel;

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

    public Single<List<LeagueTableModel>> getLeagueTable(long id) {
        return mLeaguesRepository.getLeagueTable(id);
    }

    public Single<List<List<ChampionGroupModel>>> getChampionLeagueTable(long id) {
        return mLeaguesRepository.getChampionLeagueTable(id);
    }
}
