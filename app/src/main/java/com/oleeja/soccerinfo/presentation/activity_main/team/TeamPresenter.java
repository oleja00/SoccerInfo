package com.oleeja.soccerinfo.presentation.activity_main.team;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.oleeja.soccerinfo.domain.teams.TeamInteractor;
import com.oleeja.soccerinfo.domain.teams.model.PlayerModel;
import com.oleeja.soccerinfo.domain.teams.model.TeamModel;
import com.oleeja.soccerinfo.presentation.activity_main.team.TeamFragmentContract;
import com.oleeja.soccerinfo.presentation.common.BasePresenter;
import com.oleeja.soccerinfo.presentation.common.DefaultErrorHandler;
import com.oleeja.soccerinfo.presentation.utils.RxUtils;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public final class TeamPresenter implements BasePresenter<TeamFragmentContract.View>, TeamFragmentContract.EventListener {

    public static final String TEAM_MODEL = "team_model";

    private TeamFragmentContract.View mView;
    private TeamFragmentContract.EventDelegate mEventDelegate;
    private TeamInteractor mTeamInteractor;
    private DefaultErrorHandler mErrorHandler;
    private long mId;
    private TeamModel mTeamModel;
    private boolean isNeedToShowDialog;

    @Inject
    public TeamPresenter(TeamFragmentContract.EventDelegate eventDelegate,
                         TeamInteractor teamInteractor,
                         DefaultErrorHandler errorHandler) {
        mEventDelegate = eventDelegate;
        mTeamInteractor = teamInteractor;
        mErrorHandler = errorHandler;
    }

    @Override
    public void attachView(TeamFragmentContract.View view) {
        mView = view;
    }

    public void getTeam(boolean isNeedToShowUploading){
        RxUtils.manage(this, mTeamInteractor.getTeam(mId)
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

    public void setInfo(TeamModel teamModel) {
        mTeamModel = teamModel;
        mView.showInfo(teamModel);
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
        getTeam(false);
    }

    public void setTeamId(long id) {
        mId = id;
    }

    public TeamModel onViewStateRestored(Bundle savedInstanceState) {
        if (savedInstanceState == null) return null;
        Bundle bundle = savedInstanceState.getBundle(TeamModel.class.getCanonicalName());
        if (bundle == null) return null;
        return bundle.getParcelable(TEAM_MODEL);
    }

    public void onSaveInstanceState(Bundle outState) {
        if (mTeamModel!=null) {
            if (outState == null) return;
            Bundle bundle = new Bundle();
            bundle.putParcelable(TEAM_MODEL, mTeamModel);
            outState.putParcelable(TeamModel.class.getCanonicalName(), bundle);
        }

    }

    @Override
    public void onDetailClicked(PlayerModel model) {
        mView.showPlayerInfo(model);
    }
}