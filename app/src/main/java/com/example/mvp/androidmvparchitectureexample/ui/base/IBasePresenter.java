package com.example.mvp.androidmvparchitectureexample.ui.base;

/**
 * Created by Ali DOUIRI on 13/04/2018.
 * my.alidouiri@gmail.com
 */

public interface IBasePresenter<V extends IBaseView> {

    void attachView(V view);

    void detachView();

    boolean isViewAttached();
}
