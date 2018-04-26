package com.example.mvp.androidmvparchitectureexample;

import android.app.Application;

import com.example.mvp.androidmvparchitectureexample.di.component.AppComponent;
import com.example.mvp.androidmvparchitectureexample.di.module.AppModule;
import com.example.mvp.androidmvparchitectureexample.di.DaggerAppComponent;
import com.example.mvp.androidmvparchitectureexample.di.DaggerNewsComponent;
import com.example.mvp.androidmvparchitectureexample.di.component.NewsComponent;
import com.example.mvp.androidmvparchitectureexample.di.module.NewsModule;


/**
 * Created by Ali DOUIRI on 25/04/2018.
 * my.alidouiri@gmail.com
 */

public class NewsApp extends Application{

    private static NewsComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initializeDagger();

    }

    /**
     * Initialize {@link AppComponent}
     *
     */
    private void initializeDagger(){

        mAppComponent = DaggerNewsComponent.builder().appComponent(DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build()).newsModule(new NewsModule()).
                build();

    }

    public static NewsComponent getAppComponent() {
        return mAppComponent;
    }


}
