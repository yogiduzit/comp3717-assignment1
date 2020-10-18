package com.example.verma_dam.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;

public class NewsItem {
    private static String TAG = NewsItem.class.getSimpleName();

    @SerializedName("source")
    @Expose
    private Source source;

    public Source getSource() {
        return source;
    }

    public void setSource(String id, String name) {
        this.source.setId(id);
        this.source.setName(name);
    }

    @SerializedName("title")
    @Expose
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String newsTitle) {
        this.title = newsTitle;
    }

    @SerializedName("description")
    @Expose
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @SerializedName("sourceUrl")
    @Expose
    private URL url;

    public URL getUrl() {
        return url;
    }

    public void setUrl(String url) {
        try {
            this.url = new URL(url);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @SerializedName("urlToImage")
    @Expose
    private String urltoImage;

    public String getUrltoImage() {
        return urltoImage;
    }

    public void setUrltoImage(String url) {
        this.urltoImage = url;
    }

    @SerializedName("publishedAt")
    @Expose
    private Timestamp publishedAt;

    public Timestamp getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = Timestamp.valueOf(publishedAt);
    }

    @SerializedName("content")
    @Expose
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}

class Source {
    @SerializedName("id")
    @Expose
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @SerializedName("name")
    @Expose
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
