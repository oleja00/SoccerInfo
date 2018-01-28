package com.oleeja.soccerinfo.presentation.activity_main.league.injection;

import com.oleeja.soccerinfo.di.fragment.FragmentScope;
import com.oleeja.soccerinfo.presentation.activity_main.MainRouter;
import com.oleeja.soccerinfo.presentation.activity_main.league.LeagueProfileFragment;
import com.oleeja.soccerinfo.presentation.activity_main.league.LeagueProfileFragmentContract;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@FragmentScope
@Subcomponent(modules = LeagueProfileFragmentComponent.MainModule.class)
public interface LeagueProfileFragmentComponent extends AndroidInjector<LeagueProfileFragment> {
    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<LeagueProfileFragment> {
    }

    @Module
    interface MainModule {

        @Binds
        LeagueProfileFragmentContract.EventDelegate provideRouter(MainRouter router) ;
    }
}