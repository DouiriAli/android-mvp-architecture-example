package com.example.mvp.androidmvparchitectureexample.di.module;

import com.example.mvp.androidmvparchitectureexample.data.local.LocalDataSource;
import com.example.mvp.androidmvparchitectureexample.data.remote.RemoteDataSource;
import com.example.mvp.androidmvparchitectureexample.di.scope.NewsScope;
import com.example.mvp.androidmvparchitectureexample.ui.news.NewsPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ali DOUIRI on 26/04/2018.
 * my.alidouiri@gmail.com
 */

@Module
public class NewsModule {

    @Provides
    @NewsScope
    public NewsPresenter providesNewsPresenter(LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
        return new NewsPresenter(localDataSource, remoteDataSource);
    }
}
