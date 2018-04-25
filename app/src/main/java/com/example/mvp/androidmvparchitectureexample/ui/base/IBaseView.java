package com.example.mvp.androidmvparchitectureexample.ui.base;

import android.support.annotation.StringRes;

/**
 * Created by Ali DOUIRI on 13/04/2018.
 * my.alidouiri@gmail.com
 */

public interface IBaseView {

    void showLoading();

    void hideLoading();

    void showError(String errorMessage);

    void showError(@StringRes int errorId);

}
