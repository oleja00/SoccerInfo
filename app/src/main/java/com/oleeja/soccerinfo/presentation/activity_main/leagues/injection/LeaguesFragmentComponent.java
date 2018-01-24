package com.oleeja.soccerinfo.presentation.activity_main.leagues.injection;

import com.oleeja.soccerinfo.di.fragment.FragmentScope;
import com.oleeja.soccerinfo.presentation.activity_main.MainRouter;
import com.oleeja.soccerinfo.presentation.activity_main.leagues.LeaguesFragment;
import com.oleeja.soccerinfo.presentation.activity_main.leagues.LeaguesFragmentContract;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@FragmentScope
@Subcomponent(modules = LeaguesFragmentComponent.MainModule.class)
public interface LeaguesFragmentComponent extends AndroidInjector<LeaguesFragment> {
    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<LeaguesFragment> {
    }

    @Module
    interface MainModule {

        @Binds
        LeaguesFragmentContract.EventDelegate provideRouter(MainRouter router) ;
    }
}