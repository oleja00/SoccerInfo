package com.oleeja.soccerinfo.presentation.activity_main.table;

import android.os.Bundle;

import com.oleeja.soccerinfo.domain.leagues.LeagueTableModel;
import com.oleeja.soccerinfo.domain.leagues.LeaguesInteractor;
import com.oleeja.soccerinfo.presentation.common.BasePresenter;
import com.oleeja.soccerinfo.presentation.common.DefaultErrorHandler;
import com.oleeja.soccerinfo.presentation.utils.RxUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public final class LeagueTablePresenter implements BasePresenter<LeagueTableFragmentContract.View>, LeagueTableFragmentContract.EventListener {

    private static final String LEAGUES_TABLE_MODELS = "leagues_table_models";

    private LeagueTableFragmentContract.View mView;
    private LeagueTableFragmentContract.EventDelegate mEventDelegate;
    private LeaguesInteractor mLeaguesInteractor;
    private DefaultErrorHandler mErrorHandler;
    private long mId;

    private List<LeagueTableModel> mLeagueTableModels;

    @Inject
    public LeagueTablePresenter(LeagueTableFragmentContract.EventDelegate eventDelegate,
                                LeaguesInteractor leaguesInteractor,
                                DefaultErrorHandler errorHandler) {
        mEventDelegate = eventDelegate;
        mLeaguesInteractor = leaguesInteractor;
        mErrorHandler = errorHandler;
    }

    @Override
    public void attachView(LeagueTableFragmentContract.View view) {
        mView = view;
    }

    public void getLeagueTable(boolean isNeedToShowUploading) {
        RxUtils.manage(this, mLeaguesInteractor.getLeagueTable(mId)
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

    public void setInfo(List<LeagueTableModel> leagueTableModels) {
        mLeagueTableModels = leagueTableModels;
        mView.showInfo(leagueTableModels);
    }

    @Override
    public void detachView() {
        RxUtils.unsubscribe(this);
        mView = null;
    }

    public ArrayList<LeagueTableModel> onViewStateRestored(Bundle savedInstanceState) {
        if (savedInstanceState == null) return null;
        Bundle bundle = savedInstanceState.getBundle(LeagueTableModel.class.getCanonicalName());
        if (bundle == null) return null;
        return bundle.getParcelableArrayList(LEAGUES_TABLE_MODELS);
    }

    public void onSaveInstanceState(Bundle outState) {
        if (mLeagueTableModels!=null && !mLeagueTableModels.isEmpty()) {
            if (outState == null) return;
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(LEAGUES_TABLE_MODELS, (ArrayList<LeagueTableModel>)mLeagueTableModels);
            outState.putParcelable(LeagueTableModel.class.getCanonicalName(), bundle);
        }

    }

    @Override
    public void onRefresh() {
        getLeagueTable(false);
    }

    public void setId(long id) {
        mId = id;
    }

    @Override
    public void onTeamClicked(LeagueTableModel leagueTableModel) {

    }
}