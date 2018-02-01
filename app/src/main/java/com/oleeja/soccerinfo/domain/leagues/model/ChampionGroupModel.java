package com.oleeja.soccerinfo.domain.leagues.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.oleeja.soccerinfo.presentation.common.SortedEntity;

/**
 * Created by Oleja on 31.01.2018.
 */

@AutoValue
public abstract class ChampionGroupModel implements SortedEntity, Parcelable {

    public abstract long teamId();

    public abstract String team();

    public abstract String group();

    public abstract String crestURI();


    @SuppressWarnings("ConstantConditions")
    @Override
    public boolean areItemsTheSame(SortedEntity sortedEntity) {
        return teamId() != 0 && teamId() == (((ChampionGroupModel) sortedEntity).teamId());
    }

    public static ChampionGroupModel create(long teamId, String team, String group, String crestURI) {

        return builder()
                .teamId(teamId)
                .team(team)
                .group(group)
                .crestURI(crestURI)
                .build();
    }

    @Override
    public boolean areContentsTheSame(SortedEntity sortedEntity) {
        return equals(sortedEntity);
    }

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new AutoValue_ChampionGroupModel.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Builder teamId(long teamId);

        public abstract Builder team(String team);

        public abstract Builder group(String group);

        public abstract Builder crestURI(String crestURI);

        public abstract ChampionGroupModel build();

    }
}


