package com.oleeja.soccerinfo.presentation.activity_main.team.injection;

import com.oleeja.soccerinfo.di.fragment.FragmentScope;
import com.oleeja.soccerinfo.presentation.activity_main.MainRouter;
import com.oleeja.soccerinfo.presentation.activity_main.team.TeamFragment;
import com.oleeja.soccerinfo.presentation.activity_main.team.TeamFragmentContract;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@FragmentScope
@Subcomponent(modules = TeamFragmentComponent.MainModule.class)
public interface TeamFragmentComponent extends AndroidInjector<TeamFragment> {
    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<TeamFragment> {
    }

    @Module
    interface MainModule {

        @Binds
        TeamFragmentContract.EventDelegate provideRouter(MainRouter router) ;
    }
}