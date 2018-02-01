package com.oleeja.soccerinfo.presentation.activity_main;

import com.oleeja.soccerinfo.R;
import com.oleeja.soccerinfo.domain.leagues.model.LeagueModel;
import com.oleeja.soccerinfo.presentation.activity_main.championsleague.ChampionLeagueFragment;
import com.oleeja.soccerinfo.presentation.activity_main.championsleague.ChampionLeagueFragmentContract;
import com.oleeja.soccerinfo.presentation.activity_main.league.LeagueProfileFragment;
import com.oleeja.soccerinfo.presentation.activity_main.league.LeagueProfileFragmentContract;
import com.oleeja.soccerinfo.presentation.activity_main.leagues.LeaguesFragment;
import com.oleeja.soccerinfo.presentation.activity_main.leagues.LeaguesFragmentContract;
import com.oleeja.soccerinfo.presentation.activity_main.table.LeagueTableFragment;
import com.oleeja.soccerinfo.presentation.activity_main.table.LeagueTableFragmentContract;
import com.oleeja.soccerinfo.presentation.activity_main.team.TeamFragmentContract;
import com.oleeja.soccerinfo.presentation.common.BaseRouter;

import javax.inject.Inject;

/**
 * Created by Oleja on 24.01.2018.
 */

public class MainRouter extends BaseRouter implements
        LeaguesFragmentContract.EventDelegate,
        LeagueProfileFragmentContract.EventDelegate,
        LeagueTableFragmentContract.EventDelegate,
        ChampionLeagueFragmentContract.EventDelegate,
        TeamFragmentContract.EventDelegate{

    private MainActivity mActivity;

    @Inject
    MainRouter(MainActivity activity) {
        super(activity);
        mActivity = activity;
    }

    public void showLigues() {
        replaceFragment(R.id.container, LeaguesFragment.newInstance(), LeaguesFragment.class.getCanonicalName());
    }

    @Override
    public void showLeagueProfile(LeagueModel model) {
        replaceFragmentWithBackStack(R.id.container, LeagueProfileFragment.newInstance(model), LeagueProfileFragment.class.getCanonicalName());
    }

    @Override
    public void showLeagueTable(LeagueModel model) {
        if(model.league().equals(mActivity.getString(R.string.champion_legue_key))){
            replaceFragmentWithBackStack(R.id.container, ChampionLeagueFragment.newInstance(model.id()), ChampionLeagueFragment.class.getCanonicalName());
        }else {
            replaceFragmentWithBackStack(R.id.container, LeagueTableFragment.newInstance(model.id()), LeagueTableFragment.class.getCanonicalName());
        }

    }

    @Override
    public void showTeamProfile(long id) {

    }
}
