package com.oleeja.soccerinfo.presentation.activity_main.leagues;

import android.os.Bundle;

import com.oleeja.soccerinfo.domain.leagues.LeagueModel;
import com.oleeja.soccerinfo.domain.leagues.LeaguesInteractor;
import com.oleeja.soccerinfo.presentation.common.BasePresenter;
import com.oleeja.soccerinfo.presentation.common.DefaultErrorHandler;
import com.oleeja.soccerinfo.presentation.utils.RxUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public final class LeaguesPresenter implements BasePresenter<LeaguesFragmentContract.View>, LeaguesFragmentContract.EventListener {

    private static final String LEAGUES_MODELS = "leagues_models";

    private LeaguesFragmentContract.View mView;
    private LeaguesFragmentContract.EventDelegate mEventDelegate;
    private LeaguesInteractor mLeaguesInteractor;
    private DefaultErrorHandler mErrorHandler;

    private List<LeagueModel> mLeagueModels;

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

    public void getLeagues(boolean isNeedToShowUploading) {
        RxUtils.manage(this, mLeaguesInteractor.getLeagues()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(subscription -> {
                    if(isNeedToShowUploading){
                        mView.showUploading();
                    }

                })
                .subscribe(this::setInfo,
                        throwable -> mErrorHandler.handleError(throwable, mView)));
    }

    public void setInfo(List<LeagueModel> leagueModels){
        mView.hideRefreshUploading();
        mView.hideUploading();
        mLeagueModels = leagueModels;
        mView.showInfo(leagueModels);
    }

    public ArrayList<LeagueModel> onViewStateRestored(Bundle savedInstanceState) {
        if (savedInstanceState == null) return null;
        Bundle bundle = savedInstanceState.getBundle(LeagueModel.class.getCanonicalName());
        if (bundle == null) return null;
        return bundle.getParcelableArrayList(LEAGUES_MODELS);
    }

    public void onSaveInstanceState(Bundle outState) {
        if (mLeagueModels!=null && !mLeagueModels.isEmpty()) {
            if (outState == null) return;
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(LEAGUES_MODELS, (ArrayList<LeagueModel>)mLeagueModels);
            outState.putParcelable(LeagueModel.class.getCanonicalName(), bundle);
        }

    }

    @Override
    public void detachView() {
        mView = null;
        RxUtils.unsubscribe(this);
    }

    @Override
    public void onLeagueClicked(LeagueModel model) {
        mEventDelegate.showLeagueProfile(model);
    }

    @Override
    public void onRefresh() {
        getLeagues(false);
    }
}