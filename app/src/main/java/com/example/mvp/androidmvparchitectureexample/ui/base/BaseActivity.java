package com.example.mvp.androidmvparchitectureexample.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.mvp.androidmvparchitectureexample.utils.DialogUtil;

import butterknife.Unbinder;

/**
 * Created by Ali DOUIRI on 13/04/2018.
 * my.alidouiri@gmail.com
 */

public abstract class BaseActivity extends AppCompatActivity implements IBaseView {

    protected ProgressDialog mProgressDialog;
    protected Unbinder mUnBinder;

    public void showLoading() {

        hideLoading();
        mProgressDialog = DialogUtil.showLoadingDialog(this);
    }

    public void hideLoading() {

        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }

    }

    @Override
    public void showError(String errorMessage) {

        Snackbar.make(findViewById(android.R.id.content), errorMessage, Snackbar.LENGTH_LONG)
                .show();

    }

    @Override
    public void showError(int errorId) {

        Snackbar.make(findViewById(android.R.id.content), getString(errorId), Snackbar.LENGTH_LONG)
                .show();
    }

    public void hideKeyboard() {

        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

    }

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    @Override
    protected void onDestroy() {

        if (mUnBinder != null) {
            mUnBinder.unbind();
        }

        super.onDestroy();
    }

    protected abstract void setUp();

}
