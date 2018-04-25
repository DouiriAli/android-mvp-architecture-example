package com.example.mvp.androidmvparchitectureexample.data.remote.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.mvp.androidmvparchitectureexample.data.local.ArticleEntity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ali DOUIRI on 25/04/2018.
 * my.alidouiri@gmail.com
 */

public class News implements Parcelable {

    @Expose
    @SerializedName("articles")
    private List<ArticleEntity> mArticles;

    @Expose
    @SerializedName("totalResults")
    private int mTotalResults;

    @Expose
    @SerializedName("status")
    private String mStatus;

    public List<ArticleEntity> getmArticles() {
        return mArticles;
    }

    public void setmArticles(List<ArticleEntity> mArticles) {
        this.mArticles = mArticles;
    }

    public int getmTotalResults() {
        return mTotalResults;
    }

    public void setmTotalResults(int mTotalResults) {
        this.mTotalResults = mTotalResults;
    }

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.mArticles);
        dest.writeInt(this.mTotalResults);
        dest.writeString(this.mStatus);
    }

    public News() {
    }

    protected News(Parcel in) {
        this.mArticles = new ArrayList<ArticleEntity>();
        in.readList(this.mArticles, ArticleEntity.class.getClassLoader());
        this.mTotalResults = in.readInt();
        this.mStatus = in.readString();
    }

    public static final Parcelable.Creator<News> CREATOR = new Parcelable.Creator<News>() {
        @Override
        public News createFromParcel(Parcel source) {
            return new News(source);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };
}
