package com.oleeja.soccerinfo.presentation.activity_main.leagues;

import android.support.annotation.Nullable;

import com.oleeja.soccerinfo.presentation.common.BasePresenter;
import com.oleeja.soccerinfo.presentation.common.DefaultErrorHandler;

import javax.inject.Inject;

public final class LeaguesPresenter implements BasePresenter<LeaguesFragmentContract.View>, LeaguesFragmentContract.EventListener {

    private LeaguesFragmentContract.View mView;
    private LeaguesFragmentContract.EventDelegate mEventDelegate;

    private DefaultErrorHandler mErrorHandler;

    @Inject
    public LeaguesPresenter(LeaguesFragmentContract.EventDelegate eventDelegate
            , DefaultErrorHandler errorHandler) {
        mEventDelegate = eventDelegate;
        mErrorHandler = errorHandler;
    }

    @Override
    public void attachView(LeaguesFragmentContract.View view) {
        mView = view;
//        RxUtils.manage(this, mCategoryInteractor.getIdeaFilter()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnSubscribe(subscription -> mView.showUploading())
//                .doFinally(() -> mView.hideUploading())
//                .subscribe(categoryModels -> {
//                    mView.showFilter(categoryModels);
//                }, throwable -> {
//                    mErrorHandler.handleError(throwable, s -> mView.showError(s));
//                }));
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