package com.oleeja.soccerinfo.presentation.activity_main;

import com.oleeja.soccerinfo.R;
import com.oleeja.soccerinfo.presentation.activity_main.leagues.LeaguesFragment;
import com.oleeja.soccerinfo.presentation.activity_main.leagues.LeaguesFragmentContract;
import com.oleeja.soccerinfo.presentation.common.BaseRouter;

import javax.inject.Inject;

/**
 * Created by Oleja on 24.01.2018.
 */

public class MainRouter extends BaseRouter implements
        LeaguesFragmentContract.EventDelegate{

    private MainActivity mActivity;

    @Inject
    MainRouter(MainActivity activity) {
        super(activity);
        mActivity = activity;
    }

    public void showLigues() {
        replaceFragment(R.id.container, LeaguesFragment.newInstance(), LeaguesFragment.class.getCanonicalName());
    }
}
