package com.oleeja.soccerinfo.presentation.activity_main.leagues;

import android.support.annotation.Nullable;

import com.oleeja.soccerinfo.presentation.common.BasePresenter;

import javax.inject.Inject;

public final class LeaguesPresenter implements BasePresenter<LeaguesFragmentContract.View>, LeaguesFragmentContract.EventListener {

    private LeaguesFragmentContract.View mView;
    private LeaguesFragmentContract.EventDelegate mEventDelegate;

    @Inject
    public LeaguesPresenter(LeaguesFragmentContract.EventDelegate eventDelegate) {
        mEventDelegate = eventDelegate;
    }

    @Override
    public void attachView(LeaguesFragmentContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Nullable
    LeaguesFragmentContract.View getView() {
        return mView;
    }

}