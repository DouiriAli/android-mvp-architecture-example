package com.example.mvp.androidmvparchitectureexample.data.remote;

import com.example.mvp.androidmvparchitectureexample.data.remote.model.News;

import retrofit2.Response;
import rx.Observable;

/**
 * Created by Ali DOUIRI on 18/04/2018.
 * my.alidouiri@gmail.com
 */

public class RemoteDataSource {

    private static final String TAG = RemoteDataSource.class.getSimpleName();

    private RemoteService mRemoteService;

    public RemoteDataSource(RemoteService remoteService) {
        this.mRemoteService = remoteService;
    }

    /**
     * Get articles from api
     *
     * @return
     */
    public Observable<Response<News>> getArticlesFromApi(){

        return mRemoteService.getArticleFroimApi();
    }
}
