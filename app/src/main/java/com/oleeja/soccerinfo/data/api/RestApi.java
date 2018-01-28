package com.oleeja.soccerinfo.data.api;

import com.oleeja.soccerinfo.data.api.dto.LeagueDto;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Oleja on 24.01.2018.
 */

public interface RestApi {

    @GET("soccerseasons/")
    Single<List<LeagueDto>> getLeagues();

    @GET("competitions/{id}/")
    Single<LeagueDto> getLeague(@Path("id") long id);
}
