package com.oleeja.soccerinfo.presentation.activity_main.leagues;

import com.oleeja.soccerinfo.domain.leagues.LeaguesInteractor;
import com.oleeja.soccerinfo.presentation.common.BasePresenter;
import com.oleeja.soccerinfo.presentation.common.DefaultErrorHandler;
import com.oleeja.soccerinfo.presentation.utils.RxUtils;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public final class LeaguesPresenter implements BasePresenter<LeaguesFragmentContract.View>, LeaguesFragmentContract.EventListener {

    private LeaguesFragmentContract.View mView;
    private LeaguesFragmentContract.EventDelegate mEventDelegate;
    private LeaguesInteractor mLeaguesInteractor;
    private DefaultErrorHandler mErrorHandler;

    @Inject
    public LeaguesPresenter(LeaguesFragmentContract.EventDelegate eventDelegate
            , DefaultErrorHandler errorHandler, LeaguesInteractor leaguesInteractor) {
        mEventDelegate = eventDelegate;
        mErrorHandler = errorHandler;
        mLeaguesInteractor = leaguesInteractor;
    }

    @Override
    public void attachView(LeaguesFragmentContract.View view) {
        mView = view;
    }

    public void getLeagues(){
        RxUtils.manage(this, mLeaguesInteractor.getLeagues()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(subscription -> mView.showUploading())
                .doFinally(() -> {
                    if (mView != null) {
                        mView.hideUploading();
                    }
                })
                .subscribe(mView::showInfo,
                        throwable -> mErrorHandler.handleError(throwable, mView)));
    }

    @Override
    public void detachView() {
        mView = null;
    }

}