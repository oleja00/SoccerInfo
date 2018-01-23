package com.oleeja.soccerinfo.di.app;

import com.oleeja.soccerinfo.App;
import com.oleeja.soccerinfo.di.activity.ActivityBindingsModule;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

import javax.inject.Singleton;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey Chuvashev
 * Date: 23/11/2016
 * Time: 16:10
 */

@Singleton
@Component(modules = {
        AppModule.class,
        ActivityBindingsModule.class,
        AndroidSupportInjectionModule.class
})
public interface AppComponent extends AndroidInjector<App> {
    @Component.Builder
    public abstract class Builder extends AndroidInjector.Builder<App> {
        public abstract Builder appModule(AppModule module);
    }
}
