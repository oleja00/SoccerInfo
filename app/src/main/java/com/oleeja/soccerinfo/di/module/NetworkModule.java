package com.oleeja.soccerinfo.di.module;


import com.oleeja.soccerinfo.BuildConfig;
import com.oleeja.soccerinfo.data.api.RestApi;
import com.oleeja.soccerinfo.data.utils.AuthInterceptor;
import com.oleeja.soccerinfo.presentation.utils.RxErrorCallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.oleeja.soccerinfo.Const.Network.API_VERSION;


@Module
public class NetworkModule {

    @Provides
    @Singleton
    RestApi provideRestApi(Retrofit retrofit) {
        return retrofit.create(RestApi.class);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttp) {
        RxErrorCallAdapterFactory factory = RxErrorCallAdapterFactory.create();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL  + API_VERSION + "/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(factory);

        builder.client(okHttp);

        return builder.build();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(AuthInterceptor authInterceptor) {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

        clientBuilder.addInterceptor(authInterceptor);
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            clientBuilder.addInterceptor(interceptor);
        }

        clientBuilder.retryOnConnectionFailure(true);
        return clientBuilder.build();
    }
}
