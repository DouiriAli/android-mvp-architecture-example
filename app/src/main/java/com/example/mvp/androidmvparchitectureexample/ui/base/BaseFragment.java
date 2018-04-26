package com.example.mvp.androidmvparchitectureexample.ui.base;

import android.content.Context;
import android.support.v4.app.Fragment;

import butterknife.Unbinder;

/**
 * Created by Ali DOUIRI on 26/04/2018.
 * my.alidouiri@gmail.com
 */

public abstract class BaseFragment extends Fragment implements IBaseView {

    private BaseActivity mActivity;
    private Unbinder mUnBinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof BaseActivity) {
            mActivity = (BaseActivity) context;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    protected abstract void initViews();

    public void setUnbinder(Unbinder unbinder) {
        mUnBinder = unbinder;
    }

    @Override
    public void onDestroyView() {

        if (mUnBinder != null) mUnBinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void showLoading() {

        mActivity.showLoading();
    }

    @Override
    public void hideLoading() {

        mActivity.hideLoading();

    }

    @Override
    public void showError(String errorMessage) {

        mActivity.showError(errorMessage);

    }

    @Override
    public void showError(int errorId) {

        mActivity.showError(errorId);
    }
}

