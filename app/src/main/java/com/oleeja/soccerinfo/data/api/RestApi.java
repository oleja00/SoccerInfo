package com.oleeja.soccerinfo.data.api;

import com.oleeja.soccerinfo.data.api.dto.LeagueDto;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by Oleja on 24.01.2018.
 */

public interface RestApi {

    @GET("soccerseasons/")
    Single<List<LeagueDto>> getLeagues();
}
