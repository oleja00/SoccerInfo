package com.oleeja.soccerinfo.presentation.activity_main.team;

import android.support.annotation.Nullable;

import com.oleeja.soccerinfo.presentation.activity_main.team.TeamFragmentContract;
import com.oleeja.soccerinfo.presentation.common.BasePresenter;

import javax.inject.Inject;

public final class TeamPresenter implements BasePresenter<TeamFragmentContract.View>, TeamFragmentContract.EventListener {

    private TeamFragmentContract.View mView;
    private TeamFragmentContract.EventDelegate mEventDelegate;

    @Inject
    public TeamPresenter(TeamFragmentContract.EventDelegate eventDelegate) {
        mEventDelegate = eventDelegate;
    }

    @Override
    public void attachView(TeamFragmentContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Nullable
    TeamFragmentContract.View getView() {
        return mView;
    }

    @Override
    public void onRefresh() {

    }
}