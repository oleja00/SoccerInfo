package com.oleeja.soccerinfo.presentation.common;

/**
 * Created by Oleja on 27.01.2018.
 */

public interface SortedEntity<E extends SortedEntity> {
    boolean areItemsTheSame(E var1);

    boolean areContentsTheSame(E var1);
}
