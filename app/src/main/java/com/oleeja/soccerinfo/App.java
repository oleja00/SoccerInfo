package com.oleeja.soccerinfo;

import android.app.Activity;
import android.content.Context;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.oleeja.soccerinfo.di.app.AppModule;
import com.oleeja.soccerinfo.di.app.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import timber.log.Timber;

import javax.inject.Inject;

public class App extends MultiDexApplication implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> mAndroidInjector;

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        DebugTools.init(this);
        Timber.plant(BuildConfig.DEBUG ? new Timber.DebugTree() : new RemoteTree());

        DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .create(this)
                .inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return mAndroidInjector;
    }

    private static class RemoteTree extends Timber.Tree {

        @Override
        protected boolean isLoggable(String tag, int priority) {
            return priority >= Log.ERROR;
        }

        @Override
        protected void log(int priority, String tag, String message, Throwable throwable) {
            // TODO: add logging library here
            //Crashlytics.log(priority, tag, message);
            //if (throwable != null) {
            //    Crashlytics.logException(throwable);
            //}
        }
    }
}
