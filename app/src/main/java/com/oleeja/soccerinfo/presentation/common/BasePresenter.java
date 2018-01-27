package com.oleeja.soccerinfo.presentation.common;

public interface BasePresenter<V extends BaseView> {
    void attachView(V view);

    void detachView();
}