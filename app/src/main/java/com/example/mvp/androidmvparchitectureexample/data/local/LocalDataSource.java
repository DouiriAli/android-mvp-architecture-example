package com.example.mvp.androidmvparchitectureexample.data.local;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.mvp.androidmvparchitectureexample.data.local.dao.ArticleDao;
import com.example.mvp.androidmvparchitectureexample.data.local.entities.ArticleEntity;

import javax.inject.Singleton;

/**
 * Created by Ali DOUIRI on 25/04/2018.
 * my.alidouiri@gmail.com
 */

@Singleton
@Database(entities = ArticleEntity.class, version = 1)
public abstract class LocalDataSource extends RoomDatabase {

    public abstract ArticleDao getArticleDao();

}

