package com.example.mvp.androidmvparchitectureexample.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.mvp.androidmvparchitectureexample.BuildConfig;
import com.example.mvp.androidmvparchitectureexample.data.local.ArticleDao;
import com.example.mvp.androidmvparchitectureexample.data.local.LocalDataSource;
import com.example.mvp.androidmvparchitectureexample.data.remote.RemoteDataSource;
import com.example.mvp.androidmvparchitectureexample.data.remote.RemoteService;
import com.example.mvp.androidmvparchitectureexample.utils.Constants;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DOUIRI Ali on 12/03/2018.
 * my.alidouiri@gmail.com
 */

@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    public LocalDataSource providesRoomDataSource() {
        return Room.databaseBuilder(application, LocalDataSource.class, "news_database")
                .build();
    }

    @Singleton
    @Provides
    public ArticleDao providesArticleDao(LocalDataSource localDataSource) {
        return localDataSource.getArticleDao();
    }

    @Provides
    public Context providesAppContext() {
        return application;
    }

    @Provides
    @Singleton
    public RemoteService providesRemoteService() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .build()
                .create(RemoteService.class);
    }

    private OkHttpClient getOkHttpClient(){

        return new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();

                        HttpUrl originalHttpUrl = original.url();

                        HttpUrl mUrl = originalHttpUrl.newBuilder()
                                .addQueryParameter(Constants.NAME_KEY_API_NEWS, Constants.VALUE_KEY_API_NEWS)
                                .addQueryParameter(Constants.NAME_COUNTRY_API_NEWS, Constants.VALUE_COUNTRY_API_NEWS)
                                .build();


                        Request request = original.newBuilder()
                                .header("Content-Type", "application/json")
                                .url(mUrl)
                                .build();


                        okhttp3.Response response = chain.proceed(request);
                        response.cacheResponse();
                        return response;

                    }
                })
                .readTimeout(10,TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    public RemoteDataSource providesRemoteDataSource(RemoteService remoteService) {
        return new RemoteDataSource(remoteService);
    }

}
