package com.oleeja.soccerinfo.presentation.activity_main.league;

import com.oleeja.soccerinfo.domain.leagues.LeagueModel;
import com.oleeja.soccerinfo.domain.leagues.LeaguesInteractor;
import com.oleeja.soccerinfo.presentation.common.BasePresenter;
import com.oleeja.soccerinfo.presentation.common.DefaultErrorHandler;
import com.oleeja.soccerinfo.presentation.utils.RxUtils;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public final class LeagueProfilePresenter implements BasePresenter<LeagueProfileFragmentContract.View>, LeagueProfileFragmentContract.EventListener {

    private LeagueProfileFragmentContract.View mView;
    private LeagueProfileFragmentContract.EventDelegate mEventDelegate;
    private LeaguesInteractor mLeaguesInteractor;
    private DefaultErrorHandler mErrorHandler;
    private LeagueModel mLeagueModel;

    @Inject
    public LeagueProfilePresenter(LeagueProfileFragmentContract.EventDelegate eventDelegate
            , LeaguesInteractor leaguesInteractor
            , DefaultErrorHandler errorHandler) {
        mEventDelegate = eventDelegate;
        mLeaguesInteractor = leaguesInteractor;
        mErrorHandler = errorHandler;
    }

    public void getLeague(boolean isNeedToShowUploading) {
        RxUtils.manage(this, mLeaguesInteractor.getLeague(mLeagueModel.id())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(subscription -> {
                    if (mView!=null &&isNeedToShowUploading) {
                        mView.showUploading();
                    }
                })
                .doFinally(() -> {
                    if (mView!=null) {
                        mView.hideRefreshUploading();
                        mView.hideUploading();
                    }
                })
                .subscribe(this::setInfo,
                        throwable -> mErrorHandler.handleError(throwable, mView)));
    }

    public void setInfo(LeagueModel leagueModel) {
        mLeagueModel = leagueModel;
        mView.showInfo(leagueModel);
    }

    @Override
    public void attachView(LeagueProfileFragmentContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void onRefresh() {
        getLeague(false);
    }

    @Override
    public void onDetailsClicked(LeagueModel model) {
        mEventDelegate.showLeagueTable(model);
    }
}