package com.oleeja.soccerinfo.presentation.common;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.oleeja.soccerinfo.domain.exception.ApiException;

import javax.inject.Inject;

import timber.log.Timber;


public class DefaultErrorHandler {

    protected Activity mActivity;

    @Inject
    public DefaultErrorHandler(Activity activity) {
        mActivity = activity;
    }

    public void handleError(Throwable throwable) {
        handleError(throwable, null);
    }

    public void handleError(Throwable throwable, @Nullable BaseView view) {
        Timber.e(throwable);

        if (view != null) {
            String message = null;
            if (throwable instanceof ApiException) {
                message = throwable.getMessage();
            } else {
                message = getStringMainErrorMessage();
            }
            view.showError(message);
        }

    }

    @NonNull
    public String getStringMainErrorMessage() {
        return isNetworkAvailable() ? "Server error" : "Network unavailable";
    }

    public String getStringSecondaryErrorMessage() {
        return isNetworkAvailable() ? "Can't connect to server" : "Network unavailable";
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) mActivity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}