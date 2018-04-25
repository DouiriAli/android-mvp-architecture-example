package com.example.mvp.androidmvparchitectureexample.ui.news;

import android.content.Context;

import com.example.mvp.androidmvparchitectureexample.data.local.ArticleEntity;
import com.example.mvp.androidmvparchitectureexample.ui.base.IBaseView;

import java.util.List;

/**
 * Created by Ali DOUIRI on 25/04/2018.
 * my.alidouiri@gmail.com
 */

public interface ContractNews {

    interface ContractPresenter{

        void getArticles(Context context);

        void getArticlesFromApi();

        void getArticleFromDb();

    }

    interface ContractView extends IBaseView {

        void onArtilesReady(List<ArticleEntity> items);

    }
}
