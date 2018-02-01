package com.oleeja.soccerinfo.di.app;

import com.oleeja.soccerinfo.App;
import com.oleeja.soccerinfo.di.activity.ActivityBindingsModule;
import com.oleeja.soccerinfo.di.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;


@Singleton
@Component(modules = {
        AppModule.class,
        ActivityBindingsModule.class,
        AndroidSupportInjectionModule.class,
        NetworkModule.class
})
public interface AppComponent extends AndroidInjector<App> {
    @Component.Builder
    public abstract class Builder extends AndroidInjector.Builder<App> {
        public abstract Builder appModule(AppModule module);
    }
}
