package com.oleeja.soccerinfo.presentation.utils;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.oleeja.soccerinfo.data.api.dto.ErrorDto;
import com.oleeja.soccerinfo.domain.exception.ApiException;

import org.reactivestreams.Publisher;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;


public class RxErrorCallAdapterFactory extends CallAdapter.Factory {


    public static RxErrorCallAdapterFactory create() {
        return new RxErrorCallAdapterFactory(RxJava2CallAdapterFactory.create());
    }

    private CallAdapter.Factory mOriginalAdapter;

    private RxErrorCallAdapterFactory(CallAdapter.Factory originalAdapter) {
        mOriginalAdapter = originalAdapter;
    }

    @Override
    public CallAdapter<?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        return new CallAdapterWrapper(mOriginalAdapter.get(returnType, annotations, retrofit), retrofit, returnType);
    }


    private class CallAdapterWrapper implements CallAdapter<Object> {

        private CallAdapter mWrappedAdapter;
        private Retrofit mRetrofit;
        private Type mReturnType;

        private CallAdapterWrapper(CallAdapter wrappedAdapter, Retrofit retrofit, Type returnType) {
            mWrappedAdapter = wrappedAdapter;
            mRetrofit = retrofit;
            mReturnType = returnType;
        }

        @Override
        public Type responseType() {
            return mWrappedAdapter.responseType();
        }

        @Override
        @SuppressWarnings("unchecked")
        public <R> Object adapt(Call<R> call) {
            Object observable = mWrappedAdapter.adapt(call);

            Class<?> rawType = getRawType(mReturnType);

            if (rawType == Completable.class) {
                observable = ((Completable) observable).onErrorResumeNext(throwable -> Completable.error(mapError(throwable)));
            } else if (rawType == Flowable.class) {
                observable = ((Flowable) observable).onErrorResumeNext(new Function<Throwable, Publisher>() {
                    @Override
                    public Publisher apply(Throwable throwable) throws Exception {
                        return Flowable.error(throwable);
                    }
                });
            } else if (rawType == Single.class) {
                observable = ((Single) observable).onErrorResumeNext(new Function<Throwable, SingleSource>() {
                    @Override
                    public SingleSource apply(Throwable throwable) throws Exception {
                        return Single.error(mapError(throwable));
                    }
                });
            } else if (rawType == Observable.class) {
                observable = ((Observable) observable).onErrorResumeNext(new Function<Throwable, ObservableSource>() {
                    @Override
                    public ObservableSource apply(Throwable throwable) throws Exception {
                        return Observable.error(mapError(throwable));
                    }
                });
            }

            return observable;
        }

        private Throwable mapError(Throwable throwable) throws IOException {
            if (throwable instanceof HttpException) {
                HttpException httpException = (HttpException) throwable;

                Converter<ResponseBody, ErrorDto> converter =
                        mRetrofit.responseBodyConverter(ErrorDto.class, new Annotation[0]);
                ErrorDto error = converter.convert(httpException.response().errorBody());
                return new ApiException(httpException.code(), error.error);
            }
            return throwable;
        }
    }

}
