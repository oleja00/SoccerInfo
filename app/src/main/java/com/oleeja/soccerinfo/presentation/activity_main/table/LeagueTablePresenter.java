package com.oleeja.soccerinfo.presentation.activity_main.table;

import android.support.annotation.Nullable;

import com.oleeja.soccerinfo.domain.leagues.LeaguesInteractor;
import com.oleeja.soccerinfo.presentation.common.BasePresenter;
import com.oleeja.soccerinfo.presentation.utils.RxUtils;

import javax.inject.Inject;

public final class LeagueTablePresenter implements BasePresenter<LeagueTableFragmentContract.View>, LeagueTableFragmentContract.EventListener {

    private LeagueTableFragmentContract.View mView;
    private LeagueTableFragmentContract.EventDelegate mEventDelegate;
    private LeaguesInteractor mLeaguesInteractor;

    @Inject
    public LeagueTablePresenter(LeagueTableFragmentContract.EventDelegate eventDelegate) {
        mEventDelegate = eventDelegate;
    }

    @Override
    public void attachView(LeagueTableFragmentContract.View view) {
        mView = view;
    }

//    public void getLeagueTable(long id) {
//        RxUtils.manage(this, mLeaguesInteractor.getLeagueTable()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnSubscribe(subscription -> {
//                    if(isNeedToShowUploading){
//                        mView.showUploading();
//                    }
//
//                })
//                .subscribe(this::setInfo,
//                        throwable -> mErrorHandler.handleError(throwable, mView)));
//    }

    @Override
    public void detachView() {
        RxUtils.unsubscribe(this);
        mView = null;
    }

    @Nullable
    LeagueTableFragmentContract.View getView() {
        return mView;
    }

    @Override
    public void onRefresh() {

    }
}