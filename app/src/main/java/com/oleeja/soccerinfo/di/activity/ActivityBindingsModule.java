package com.oleeja.soccerinfo.di.activity;

import android.app.Activity;

import com.oleeja.soccerinfo.presentation.activity_main.MainActivity;
import com.oleeja.soccerinfo.presentation.activity_main.MainActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
        MainActivityComponent.class
})
public abstract class ActivityBindingsModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> MainActivityComponentBuilder(MainActivityComponent.Builder builder);
}
