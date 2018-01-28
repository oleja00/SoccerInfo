package com.oleeja.soccerinfo.presentation.activity_main;

import com.oleeja.soccerinfo.R;
import com.oleeja.soccerinfo.domain.leagues.LeagueModel;
import com.oleeja.soccerinfo.presentation.activity_main.league.LeagueProfileFragment;
import com.oleeja.soccerinfo.presentation.activity_main.league.LeagueProfileFragmentContract;
import com.oleeja.soccerinfo.presentation.activity_main.leagues.LeaguesFragment;
import com.oleeja.soccerinfo.presentation.activity_main.leagues.LeaguesFragmentContract;
import com.oleeja.soccerinfo.presentation.common.BaseRouter;

import javax.inject.Inject;

/**
 * Created by Oleja on 24.01.2018.
 */

public class MainRouter extends BaseRouter implements
        LeaguesFragmentContract.EventDelegate,
        LeagueProfileFragmentContract.EventDelegate {

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
        addFragmentWithBackStack(R.id.container, LeagueProfileFragment.newInstance(model), LeagueProfileFragment.class.getCanonicalName());
    }
}
