package com.example.mvp.androidmvparchitectureexample.ui.base;

import rx.Subscription;

/**
 * Created by Ali DOUIRI on 13/04/2018.
 * my.alidouiri@gmail.com
 */

public class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {

    private V mView;
    private Subscription mSubscription;


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
