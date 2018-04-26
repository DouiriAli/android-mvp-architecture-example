package com.example.mvp.androidmvparchitectureexample.ui.news;

import android.content.Context;
import android.util.Log;

import com.example.mvp.androidmvparchitectureexample.data.local.LocalDataSource;
import com.example.mvp.androidmvparchitectureexample.data.remote.RemoteDataSource;
import com.example.mvp.androidmvparchitectureexample.ui.base.BasePresenter;
import com.example.mvp.androidmvparchitectureexample.utils.NetworkUtil;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by Ali DOUIRI on 25/04/2018.
 * my.alidouiri@gmail.com
 */

public class NewsPresenter extends BasePresenter<ContractNews.ContractView> implements ContractNews.ContractPresenter {

    private static final String TAG = NewsPresenter.class.getSimpleName();

    LocalDataSource mLocalDataSource;
    RemoteDataSource mRemoteDataSource;

    public NewsPresenter(LocalDataSource mLocalDataSource, RemoteDataSource mRemoteDataSource) {

        this.mLocalDataSource = mLocalDataSource;
        this.mRemoteDataSource = mRemoteDataSource;
    }

    @Override
    public void getArticles(Context context) {

        if (NetworkUtil.isNetworkConnected(context))
            getArticlesFromApi();
        else
            getArticleFromDb();
    }

    @Override
    public void getArticlesFromApi() {

        getView().showLoading();

        mRemoteDataSource.getArticlesFromApi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {

                            if(!isViewAttached())
                                return;

                            getView().hideLoading();
                            if (response.isSuccessful())
                                getView().onArtilesReady(response.body().getmArticles());
                        },
                        throwable -> {
                            getView().hideLoading();
                            Log.e(TAG, throwable.getMessage());
                        });

    }

    @Override
    public void getArticleFromDb() {



    }
}
