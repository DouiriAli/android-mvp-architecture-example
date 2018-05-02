package com.example.mvp.androidmvparchitectureexample.data.local.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "article")
public class ArticleEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @Expose
    @SerializedName("publishedAt")
    @ColumnInfo(name = "publishedAt")
    private String publishedAt;

    @Expose
    @SerializedName("urlToImage")
    @ColumnInfo(name = "urlToImage")
    private String urlToImage;

    @Expose
    @SerializedName("url")
    @ColumnInfo(name = "url")
    private String url;

    @Expose
    @SerializedName("description")
    @ColumnInfo(name = "description")
    private String description;

    @Expose
    @SerializedName("title")
    @ColumnInfo(name = "title")
    private String title;

    @Expose
    @SerializedName("author")
    @ColumnInfo(name = "author")
    private String author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
