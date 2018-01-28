package com.oleeja.soccerinfo.presentation.activity_main;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.oleeja.soccerinfo.di.activity.ActivityScope;
import com.oleeja.soccerinfo.presentation.activity_main.league.LeagueProfileFragment;
import com.oleeja.soccerinfo.presentation.activity_main.league.injection.LeagueProfileFragmentComponent;
import com.oleeja.soccerinfo.presentation.activity_main.leagues.LeaguesFragment;
import com.oleeja.soccerinfo.presentation.activity_main.leagues.injection.LeaguesFragmentComponent;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@ActivityScope
@Subcomponent(modules = {
        MainActivityComponent.MainActivityModule.class,
        MainActivityComponent.FragmentBindingsModule.class,
})
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<MainActivity> {
    }

    @Module
    class MainActivityModule {
        @Provides
        Activity provideActivity(MainActivity activity) {
            return activity;
        }
    }

    @Module(subcomponents = {LeaguesFragmentComponent.class,
            LeagueProfileFragmentComponent.class})
    abstract class FragmentBindingsModule {
        @Binds
        @IntoMap
        @FragmentKey(LeaguesFragment.class)
        public abstract AndroidInjector.Factory<? extends Fragment> leagueFragmentComponentBuilder(LeaguesFragmentComponent.Builder builder);

        @Binds
        @IntoMap
        @FragmentKey(LeagueProfileFragment.class)
        public abstract AndroidInjector.Factory<? extends Fragment> leagueProfileFragmentComponentBuilder(LeagueProfileFragmentComponent.Builder builder);

    }

}
