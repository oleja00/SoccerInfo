package com.oleeja.soccerinfo.presentation.activity_main.table.injection;

import com.oleeja.soccerinfo.di.fragment.FragmentScope;
import com.oleeja.soccerinfo.presentation.activity_main.MainRouter;
import com.oleeja.soccerinfo.presentation.activity_main.table.LeagueTableFragment;
import com.oleeja.soccerinfo.presentation.activity_main.table.LeagueTableFragmentContract;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@FragmentScope
@Subcomponent(modules = LeagueTableFragmentComponent.MainModule.class)
public interface LeagueTableFragmentComponent extends AndroidInjector<LeagueTableFragment> {
    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<LeagueTableFragment> {
    }

    @Module
    interface MainModule {

        @Binds
        LeagueTableFragmentContract.EventDelegate provideRouter(MainRouter router) ;
    }
}