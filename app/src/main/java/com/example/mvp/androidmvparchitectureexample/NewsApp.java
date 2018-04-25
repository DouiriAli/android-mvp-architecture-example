package com.example.mvp.androidmvparchitectureexample;

import android.app.Application;

import com.example.mvp.androidmvparchitectureexample.di.AppComponent;
import com.example.mvp.androidmvparchitectureexample.di.AppModule;
import com.example.mvp.androidmvparchitectureexample.di.DaggerNewsComponent;

/**
 * Created by Ali DOUIRI on 25/04/2018.
 * my.alidouiri@gmail.com
 */

public class NewsApp extends Application{

    private static AppComponent mAppComponent;

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

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

    }

    public static AppComponent getAppComponent() {
        return mAppComponent;
    }

}
