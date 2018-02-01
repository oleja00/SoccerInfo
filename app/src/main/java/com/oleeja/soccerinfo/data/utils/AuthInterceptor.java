package com.oleeja.soccerinfo.data.utils;

import android.content.Context;

import com.oleeja.soccerinfo.R;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static com.oleeja.soccerinfo.Const.Network.X_AUTH_TOKEN;


@Singleton
public class AuthInterceptor implements Interceptor {

    private Context mContext;

    @Inject
    AuthInterceptor(Context context) {
        mContext = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        builder.addHeader(X_AUTH_TOKEN, mContext.getString(R.string.api_key) );
        return chain.proceed(builder.build());
    }
}
