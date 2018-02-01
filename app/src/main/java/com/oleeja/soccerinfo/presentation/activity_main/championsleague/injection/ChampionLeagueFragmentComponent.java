package com.oleeja.soccerinfo.presentation.activity_main.championsleague.injection;

import com.oleeja.soccerinfo.di.fragment.FragmentScope;
import com.oleeja.soccerinfo.presentation.activity_main.MainRouter;
import com.oleeja.soccerinfo.presentation.activity_main.championsleague.ChampionLeagueFragment;
import com.oleeja.soccerinfo.presentation.activity_main.championsleague.ChampionLeagueFragmentContract;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@FragmentScope
@Subcomponent(modules = ChampionLeagueFragmentComponent.MainModule.class)
public interface ChampionLeagueFragmentComponent extends AndroidInjector<ChampionLeagueFragment> {
    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<ChampionLeagueFragment> {
    }

    @Module
    interface MainModule {

        @Binds
        ChampionLeagueFragmentContract.EventDelegate provideRouter(MainRouter router) ;
    }
}