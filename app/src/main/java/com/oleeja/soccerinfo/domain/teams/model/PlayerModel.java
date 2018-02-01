package com.oleeja.soccerinfo.domain.teams.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.oleeja.soccerinfo.presentation.common.SortedEntity;

/**
 * Created by Oleja on 01.02.2018.
 */

@AutoValue
public abstract class PlayerModel implements SortedEntity, Parcelable {

    public abstract String name();

    public abstract String position();

    public abstract long jerseyNumber();

    public abstract String dateOfBirth();

    public abstract String nationality();

    public abstract String contractUntil();

    public static PlayerModel create(String name, String position, long jerseyNumber, String dateOfBirth,
                                     String nationality, String contractUntil) {

        return builder()
                .name(name==null? "":name)
                .position(position==null? "":position)
                .jerseyNumber(jerseyNumber)
                .dateOfBirth(dateOfBirth==null? "": dateOfBirth)
                .nationality(nationality==null? "": nationality)
                .contractUntil(contractUntil==null? "": contractUntil)
                .build();
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public boolean areItemsTheSame(SortedEntity sortedEntity) {
        return name() != null && name().equals(((PlayerModel) sortedEntity).name());
    }

    @Override
    public boolean areContentsTheSame(SortedEntity sortedEntity) {
        return equals(sortedEntity);
    }

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new AutoValue_PlayerModel.Builder();
    }


    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Builder name(String name);

        public abstract Builder position(String position);

        public abstract Builder jerseyNumber(long jerseyNumber);

        public abstract Builder dateOfBirth(String dateOfBirth);

        public abstract Builder nationality(String nationality);

        public abstract Builder contractUntil(String contractUntil);

        public abstract PlayerModel build();

    }
}
