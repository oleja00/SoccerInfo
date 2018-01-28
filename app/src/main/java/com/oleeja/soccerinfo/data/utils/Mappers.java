package com.oleeja.soccerinfo.data.utils;

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Mappers {
    public Mappers() {
    }

    public static <F, T> List<T> mapCollection(@Nullable List<F> list, Mapper<F, T> mapper) {
        if(list == null) {
            return Collections.emptyList();
        } else {
            int size = list.size();
            ArrayList<T> result = new ArrayList(size);

            for(int i = 0; i < size; ++i) {
                result.add(mapper.map(list.get(i)));
            }

            return result;
        }
    }
}

