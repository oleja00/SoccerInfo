package com.oleeja.soccerinfo.domain.leagues;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Oleja on 25.01.2018.
 */

public interface LeaguesRepository {
    Single <List<LeagueModel>> getLeagues();

    Single<LeagueModel> getLeague(long id);

    Single<List<LeagueTableModel>> getLeagueTable(long id);

    Single<List<List<ChampionGroupModel>>> getChampionLeagueTable(long id);
}
