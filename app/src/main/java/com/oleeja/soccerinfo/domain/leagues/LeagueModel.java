package com.oleeja.soccerinfo.domain.leagues;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.oleeja.soccerinfo.presentation.common.SortedEntity;

/**
 * Created by Oleja on 27.01.2018.
 */

@AutoValue
public abstract class LeagueModel implements SortedEntity, Parcelable{

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

        return builder()
                .id(id)
              .caption(caption)
                .league(league)
                .year(year)
                .currentMatchday(currentMatchday)
                .numberOfMatchdays(numberOfMatchdays)
                .numberOfTeams(numberOfTeams)
                .numberOfGames(numberOfGames)
                .lastUpdated(lastUpdated)
                .build();
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

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new AutoValue_LeagueModel.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Builder id(long id);

        public abstract Builder caption(String caption);

        public abstract Builder league(String league);

        public abstract Builder year(String year);

        public abstract Builder currentMatchday(long currentMatchday);

        public abstract Builder numberOfMatchdays(long numberOfMatchdays);

        public abstract Builder numberOfTeams(long numberOfTeams);

        public abstract Builder numberOfGames(long numberOfGames);

        public abstract Builder lastUpdated(String lastUpdated);

        public abstract LeagueModel build();

    }
}
