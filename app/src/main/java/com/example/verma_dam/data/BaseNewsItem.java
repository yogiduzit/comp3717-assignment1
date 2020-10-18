package com.example.verma_dam.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BaseNewsItem {
    @SerializedName(value = "newsItems", alternate = {"articles"})
    @Expose
    private ArrayList<NewsItem> newsItems = new ArrayList<>();

    public ArrayList<NewsItem> getNewsItems() {
        return newsItems;
    }

    public void setNewsItems(ArrayList<NewsItem> newsItems) {
        this.newsItems = newsItems;
    }
}
