package com.example.mvp.androidmvparchitectureexample.ui.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mvp.androidmvparchitectureexample.R;
import com.example.mvp.androidmvparchitectureexample.data.local.ArticleEntity;
import com.example.mvp.androidmvparchitectureexample.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ali DOUIRI on 25/04/2018.
 * my.alidouiri@gmail.com
 */

public class NewsActivity extends BaseActivity implements ContractNews.ContractView {

    private static final String TAG = NewsActivity.class.getSimpleName();

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    private NewsAdapter mAdapter;

    @Inject
    NewsPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        ButterKnife.bind(this);

        setUp();

        mPresenter.attachView(this);

        mPresenter.getArticles(this);

    }

    @Override
    protected void setUp() {

        mAdapter = new NewsAdapter(this, new ArrayList<>());

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerview.setLayoutManager(mLayoutManager);
        mRecyclerview.setItemAnimator(new DefaultItemAnimator());
        mRecyclerview.setAdapter(mAdapter);

    }

    @Override
    public void onArtilesReady(List<ArticleEntity> items) {

        mAdapter.setItems(items);

    }

    @Override
    protected void onDestroy() {

        mPresenter.detachView();
        super.onDestroy();
    }
}
