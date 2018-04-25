package com.example.mvp.androidmvparchitectureexample.ui.news;

import android.content.Context;
import android.util.Log;

import com.example.mvp.androidmvparchitectureexample.ui.base.BasePresenter;
import com.example.mvp.androidmvparchitectureexample.utils.NetworkUtil;


/**
 * Created by Ali DOUIRI on 25/04/2018.
 * my.alidouiri@gmail.com
 */

public class NewsPresenter extends BasePresenter<ContractNews.ContractView> implements ContractNews.ContractPresenter {

    private static final String TAG = NewsPresenter.class.getSimpleName();


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

        getRemoteDataSource().getArticlesFromApi()
                .subscribe(response -> {

                            if(!isViewAttached())
                                return;

                            getView().hideLoading();
                            if (response.isSuccessful() && response.body().getmStatus().equalsIgnoreCase("200"))
                                getView().onArtilesReady(response.body().getmArticles());
                        },
                        throwable -> {
                            getView().hideLoading();
                            Log.e(TAG, throwable.getMessage());
                        });

    }

    @Override
    public void getArticleFromDb() {

        getView().showLoading();

        getLocalDataSource().getArticleDao().getArticlesFromDb()
                .subscribe(articlesEntities -> {

                            if(!isViewAttached())
                                return;

                            getView().hideLoading();
                            getView().onArtilesReady(articlesEntities);
                        },
                        throwable -> {
                            getView().hideLoading();
                            Log.e(TAG,  throwable.getMessage());
                        });

    }
}
