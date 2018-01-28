package com.oleeja.soccerinfo.presentation.activity_main.league;

import com.oleeja.soccerinfo.presentation.common.BasePresenter;

import javax.inject.Inject;

public final class LeagueProfilePresenter implements BasePresenter<LeagueProfileFragmentContract.View>, LeagueProfileFragmentContract.EventListener {

    private LeagueProfileFragmentContract.View mView;
    private LeagueProfileFragmentContract.EventDelegate mEventDelegate;

    @Inject
    public LeagueProfilePresenter(LeagueProfileFragmentContract.EventDelegate eventDelegate) {
        mEventDelegate = eventDelegate;
    }

    @Override
    public void attachView(LeagueProfileFragmentContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

}