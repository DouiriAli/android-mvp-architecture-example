package com.example.mvp.androidmvparchitectureexample.ui.base;

import com.example.mvp.androidmvparchitectureexample.data.local.LocalDataSource;
import com.example.mvp.androidmvparchitectureexample.data.remote.RemoteDataSource;

import javax.inject.Inject;

import rx.Subscription;

/**
 * Created by Ali DOUIRI on 13/04/2018.
 * my.alidouiri@gmail.com
 */

public class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {

    private V mView;
    private Subscription mSubscription;

    @Inject
    LocalDataSource mLocalDataSource;

    @Inject
    RemoteDataSource mRemoteDataSource;


    @Override
    public void attachView(V view) {
        mView = view;
    }

    @Override
    public void detachView() {

        if(mView != null)
            mView = null;

        if(mSubscription != null && !mSubscription.isUnsubscribed())
            mSubscription.unsubscribe();
    }

    public boolean isViewAttached() {
        return mView != null;
    }

    public V getView() {
        return mView;
    }

    public LocalDataSource getLocalDataSource() {
        return mLocalDataSource;
    }

    public RemoteDataSource getRemoteDataSource() {
        return mRemoteDataSource;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new ViewNotAttachedException();
    }


    public static class ViewNotAttachedException extends RuntimeException {
        public ViewNotAttachedException() {
            super("Please call Presenter.attachView(view) before" +
                    " requesting data to the Presenter");
        }
    }

}
