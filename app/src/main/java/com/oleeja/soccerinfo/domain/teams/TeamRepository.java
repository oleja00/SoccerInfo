package com.oleeja.soccerinfo.domain.teams;

import com.oleeja.soccerinfo.domain.teams.model.PlayerModel;
import com.oleeja.soccerinfo.domain.teams.model.TeamModel;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Oleja on 01.02.2018.
 */

public interface TeamRepository {
    Single<TeamModel> getTeam(long id);
    Single<List<PlayerModel>> getPlayers(long id);
}
