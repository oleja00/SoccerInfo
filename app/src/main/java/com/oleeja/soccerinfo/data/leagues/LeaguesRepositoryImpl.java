package com.oleeja.soccerinfo.data.leagues;

import com.oleeja.soccerinfo.data.api.RestApi;
import com.oleeja.soccerinfo.domain.leagues.LeaguesRepository;

import javax.inject.Inject;

/**
 * Created by Oleja on 25.01.2018.
 */

public class LeaguesRepositoryImpl implements LeaguesRepository {

    private RestApi mRestApi;

    @Inject
    public LeaguesRepositoryImpl(RestApi restApi){
        mRestApi = restApi;
    }
}
