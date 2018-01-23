package com.oleeja.soccerinfo.presentation.activity_main;

import android.app.Activity;

import com.oleeja.soccerinfo.di.activity.ActivityScope;

import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

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

    @Module(subcomponents = {/*MainFragmentComponent.class*/})
    abstract class FragmentBindingsModule {
/*        @Binds
        @IntoMap
        @FragmentKey(MainFragment.class)
        public abstract AndroidInjector.Factory<? extends Fragment> mainFragmentComponentBuilder(MainFragmentComponent.Builder builder);
        */
    }

}
