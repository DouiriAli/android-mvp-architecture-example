package com.example.mvp.androidmvparchitectureexample.data.remote;

import com.example.mvp.androidmvparchitectureexample.data.remote.model.News;

import io.reactivex.Flowable;
import retrofit2.Response;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Ali DOUIRI on 18/04/2018.
 * my.alidouiri@gmail.com
 */

public interface RemoteService {

    @GET(".")
    Flowable<Response<News>> getArticleFroimApi();
}
