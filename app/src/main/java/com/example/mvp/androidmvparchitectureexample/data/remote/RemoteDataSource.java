package com.example.mvp.androidmvparchitectureexample.data.remote;

import com.example.mvp.androidmvparchitectureexample.data.remote.model.News;

import io.reactivex.Flowable;
import retrofit2.Response;
import rx.Observable;

/**
 * Created by Ali DOUIRI on 18/04/2018.
 * my.alidouiri@gmail.com
 */

public class RemoteDataSource {

    private static final String TAG = RemoteDataSource.class.getSimpleName();

    private RemoteService mRemoteService;

    public RemoteDataSource(RemoteService remoteUserService) {
        this.mRemoteService = remoteUserService;
    }

    /**
     * Get articles from api
     *
     * @return
     */
    public Flowable<Response<News>> getArticlesFromApi(){

        return mRemoteService.getArticleFroimApi();
    }
}
