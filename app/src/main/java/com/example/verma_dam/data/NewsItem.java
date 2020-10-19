package com.example.verma_dam.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.net.URL;
import java.sql.Timestamp;

public class NewsItem implements Parcelable {
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

    @SerializedName("author")
    @Expose
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    @SerializedName("url")
    @Expose
    private URL url;

    public URL getUrl() {
        return url;
    }

    public void setUrl(String url) {
        try {
            this.url = new URL(url);
        } catch (Exception ex) {
            Log.e(TAG, ex.getMessage());
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

    protected NewsItem(Parcel in) {
        title = in.readString();
        description = in.readString();
        author = in.readString();
        source = in.readParcelable(Source.class.getClassLoader());
        try {
            url = new URL(in.readString());
        } catch (Exception ex) {
            Log.e(TAG, ex.getMessage());
        }
        urltoImage = in.readString();
        content = in.readString();
        publishedAt = Timestamp.valueOf(in.readString());
    }

    public static final Creator<NewsItem> CREATOR = new Creator<NewsItem>() {
        @Override
        public NewsItem createFromParcel(Parcel in) {
            return new NewsItem(in);
        }

        @Override
        public NewsItem[] newArray(int size) {
            return new NewsItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(author);
        dest.writeParcelable(source, PARCELABLE_WRITE_RETURN_VALUE);
        dest.writeString(url != null ? url.toString() : null);
        dest.writeString(urltoImage);
        dest.writeString(content);
        dest.writeString(publishedAt.toString());
    }
}