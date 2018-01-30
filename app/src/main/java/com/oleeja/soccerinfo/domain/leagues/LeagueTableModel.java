package com.oleeja.soccerinfo.domain.leagues;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.oleeja.soccerinfo.presentation.common.SortedEntity;

/**
 * Created by Oleja on 29.01.2018.
 */

@AutoValue
public abstract class LeagueTableModel implements SortedEntity, Parcelable {

    public abstract long id();
    public abstract long position();
    public abstract String teamName();
    public abstract String logoUrl();
    public abstract long playGames();
    public abstract long points();
    public abstract long goals();
    public abstract long goalsAgainst();
    public abstract long goalDifference();
    public abstract long wins();
    public abstract long draws();
    public abstract long loses();


    public static LeagueTableModel create(long id, long position, String teamName, String logoUrl, long playGames,
                                          long points, long goals, long goalsAgainst, long goalDifference, long wins,
                                          long draws, long loses){

        return builder()
                .id(id)
                .position(position)
                .teamName(teamName)
                .logoUrl(logoUrl==null ? "" : logoUrl)
                .playGames(playGames)
                .points(points)
                .goals(goals)
                .goalsAgainst(goalsAgainst)
                .goalDifference(goalDifference)
                .wins(wins)
                .draws(draws)
                .loses(loses)
                .build();
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public boolean areItemsTheSame(SortedEntity sortedEntity) {
        return id() != 0 && id()==(((LeagueTableModel) sortedEntity).id());
    }

    @Override
    public boolean areContentsTheSame(SortedEntity sortedEntity) {
        return equals(sortedEntity);
    }

    public abstract LeagueTableModel.Builder toBuilder();

    public static LeagueTableModel.Builder builder() {
        return new AutoValue_LeagueTableModel.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Builder id(long id);

        public abstract Builder position(long position);

        public abstract Builder teamName(String teamName);

        public abstract Builder logoUrl(String logoUrl);

        public abstract Builder playGames(long playGames);

        public abstract Builder points(long points);

        public abstract Builder goals(long goals);

        public abstract Builder goalsAgainst(long goalsAgainst);

        public abstract Builder goalDifference(long goalDifference);

        public abstract Builder wins(long wins);

        public abstract Builder draws(long draws);

        public abstract Builder loses(long loses);

        public abstract LeagueTableModel build();

    }

}
