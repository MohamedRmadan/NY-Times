package com.example.nytimes.model;

import com.google.gson.annotations.SerializedName;

public class NyArticle {
    @SerializedName("title")
    private String title;

    @SerializedName("id")
    private String id;

    @SerializedName("byline")
    private String byline;

    @SerializedName("published_date")
    private String published_date;


    public NyArticle(String id, String title, String byline, String published_date) {
        this.id = id;
        this.title = title;
        this.byline = byline;
        this.published_date = published_date;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }
}
