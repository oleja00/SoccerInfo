package com.oleeja.soccerinfo.presentation.activity_main.championsleague;

import com.oleeja.soccerinfo.presentation.common.BasePresenter;
import com.oleeja.soccerinfo.presentation.utils.RxUtils;

import javax.inject.Inject;

public final class ChampionLeaguePresenter implements BasePresenter<ChampionLeagueFragmentContract.View>, ChampionLeagueFragmentContract.EventListener {

    private ChampionLeagueFragmentContract.View mView;
    private ChampionLeagueFragmentContract.EventDelegate mEventDelegate;

    @Inject
    public ChampionLeaguePresenter(ChampionLeagueFragmentContract.EventDelegate eventDelegate) {
        mEventDelegate = eventDelegate;
    }

    @Override
    public void attachView(ChampionLeagueFragmentContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        RxUtils.unsubscribe(this);
        mView = null;
    }

}