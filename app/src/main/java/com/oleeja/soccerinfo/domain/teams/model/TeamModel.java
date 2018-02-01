package com.oleeja.soccerinfo.domain.teams.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.oleeja.soccerinfo.presentation.common.SortedEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleja on 01.02.2018.
 */

@AutoValue
public abstract class TeamModel implements SortedEntity, Parcelable {

    public abstract String name();

    public abstract String code();

    public abstract String shortName();

    public abstract String crestUrl();

    public abstract List<PlayerModel> playerModels();

    public static TeamModel create(String name, String code, String shortName, String crestUri) {

        return builder()
                .name(name==null? "":name)
                .code(code==null? "" :code)
                .shortName(shortName==null? "" :shortName)
                .crestUrl(crestUri==null?"" : crestUri)
                .playerModels(new ArrayList<>())
                .build();
    }

    public void addPlayers(List<PlayerModel> playerModels){
        playerModels().addAll(playerModels);
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public boolean areItemsTheSame(SortedEntity sortedEntity) {
        return name() != null && name().equals(((TeamModel) sortedEntity).name());
    }

    @Override
    public boolean areContentsTheSame(SortedEntity sortedEntity) {
        return equals(sortedEntity);
    }

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new AutoValue_TeamModel.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Builder name(String name);

        public abstract Builder code(String code);

        public abstract Builder shortName(String shortName);

        public abstract Builder crestUrl(String crestUrl);

        public abstract Builder playerModels(List<PlayerModel> playerModels);

        public abstract TeamModel build();

    }
}
