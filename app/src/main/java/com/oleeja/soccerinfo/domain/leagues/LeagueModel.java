package com.oleeja.soccerinfo.domain.leagues;

import com.google.auto.value.AutoValue;
import com.oleeja.soccerinfo.presentation.common.SortedEntity;

/**
 * Created by Oleja on 27.01.2018.
 */

@AutoValue
public abstract class LeagueModel implements SortedEntity {

    public abstract long id();

    public abstract String caption();

    public abstract String league();

    public abstract String year();

    public abstract long currentMatchday();

    public abstract long numberOfMatchdays();

    public abstract long numberOfTeams();

    public abstract long numberOfGames();

    public abstract String lastUpdated();

    public static LeagueModel create(long id, String caption, String league, String year, long currentMatchday,
                                     long numberOfMatchdays, long numberOfTeams, long numberOfGames,
                                     String lastUpdated){
        return new AutoValue_LeagueModel(id, caption, league, year, currentMatchday, numberOfMatchdays,
                numberOfTeams, numberOfGames, lastUpdated);
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public boolean areItemsTheSame(SortedEntity sortedEntity) {
        return id() != 0 && id()==(((LeagueModel) sortedEntity).id());
    }

    @Override
    public boolean areContentsTheSame(SortedEntity sortedEntity) {
        return equals(sortedEntity);
    }
}
