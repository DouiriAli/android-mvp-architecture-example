package com.example.mvp.androidmvparchitectureexample.di;

import com.example.mvp.androidmvparchitectureexample.ui.news.NewsActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by DOUIRI Ali on 12/03/2018.
 * my.alidouiri@gmail.com
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(NewsActivity view);

}
