package com.oleeja.soccerinfo.presentation.activity_main.championsleague;

import android.os.Bundle;

import com.oleeja.soccerinfo.domain.leagues.model.ChampionGroupModel;
import com.oleeja.soccerinfo.domain.leagues.LeaguesInteractor;
import com.oleeja.soccerinfo.presentation.common.BasePresenter;
import com.oleeja.soccerinfo.presentation.common.DefaultErrorHandler;
import com.oleeja.soccerinfo.presentation.utils.RxUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public final class ChampionLeaguePresenter implements BasePresenter<ChampionLeagueFragmentContract.View>, ChampionLeagueFragmentContract.EventListener {

    private ChampionLeagueFragmentContract.View mView;
    private ChampionLeagueFragmentContract.EventDelegate mEventDelegate;
    private LeaguesInteractor mLeaguesInteractor;
    private DefaultErrorHandler mErrorHandler;
    private long mId;
    private List<List<ChampionGroupModel>> mListsChampionModel;

    @Inject
    public ChampionLeaguePresenter(ChampionLeagueFragmentContract.EventDelegate eventDelegate,
                                   LeaguesInteractor leaguesInteractor,
                                   DefaultErrorHandler errorHandler) {
        mEventDelegate = eventDelegate;
        mLeaguesInteractor = leaguesInteractor;
        mErrorHandler = errorHandler;
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

    public void getChampionTable(boolean isNeedToShowUploading){
        RxUtils.manage(this, mLeaguesInteractor.getChampionLeagueTable(mId)
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

    public void setId(long id) {
        mId = id;
    }

    public List<List<ChampionGroupModel>> onViewStateRestored(Bundle savedInstanceState) {
        if (savedInstanceState == null) return null;
        Bundle bundle = savedInstanceState.getBundle(ChampionGroupModel.class.getCanonicalName());
        if (bundle == null) return null;
        List<List<ChampionGroupModel>> lists = new ArrayList<>();

        int i = 0;
        while (bundle.getParcelableArrayList(String.valueOf(i))!=null){
            lists.add(bundle.getParcelableArrayList(String.valueOf(i)));
            i++;
        }
        return lists;
    }

    public void onSaveInstanceState(Bundle outState) {
        if (mListsChampionModel!=null && !mListsChampionModel.isEmpty()) {
            if (outState == null) return;
            Bundle bundle = new Bundle();
            for (int i = 0; i < mListsChampionModel.size(); i++) {
                bundle.putParcelableArrayList(String.valueOf(i), (ArrayList<ChampionGroupModel>)mListsChampionModel.get(i));
            }
            outState.putParcelable(ChampionGroupModel.class.getCanonicalName(), bundle);
        }

    }

    public void setInfo(List<List<ChampionGroupModel>> lists) {
        mListsChampionModel = lists;
        mView.showInfo(lists);
    }

    @Override
    public void onRefresh() {
        getChampionTable(false);
    }

    @Override
    public void onTeamClicked(ChampionGroupModel championGroupModel) {
        mEventDelegate.showTeamProfile(championGroupModel.teamId());
    }
}