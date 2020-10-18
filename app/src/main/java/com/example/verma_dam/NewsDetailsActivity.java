package com.example.verma_dam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.format.DateUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.verma_dam.data.NewsItem;
import com.example.verma_dam.data.Source;

import java.net.URL;
import java.sql.Timestamp;

public class NewsDetailsActivity extends AppCompatActivity {

    private final static String ORIGINAL_STORY_CAPTION = "Click here for original story";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        setupNewsDetails();
    }

    private void setupNewsDetails() {
        NewsItem newsItem = getIntent().getParcelableExtra(NewsListActivity.PARCEL_NAME);

        setupTitle(newsItem.getTitle());
        setupDescription(newsItem.getDescription());
        setupArticlePicture(newsItem.getUrltoImage());
        setupSource(newsItem.getSource());
        setupAuthor(newsItem.getAuthor());
        setupPublishedAt(newsItem.getPublishedAt());
        setupContent(newsItem.getContent());
        setupOriginalURL(newsItem.getUrl());
    }

    private void setupTitle(String titleInput) {
        TextView title = findViewById(R.id.title);
        title.setText(titleInput);
    }

    private void setupDescription(String descInput) {
        TextView description = findViewById(R.id.description);
        description.setText(descInput);
    }

    private void setupArticlePicture(String urlToImage) {
        ImageView thumbnail = findViewById(R.id.article_photo);
        if (urlToImage != null) {
            Glide.with(getApplicationContext())
                    .load(urlToImage)
                    .into(thumbnail);
        }
    }

    private void setupSource(Source source) {
        TextView newsSource = findViewById(R.id.source);
        newsSource.setText(source.getName());
    }

    private void setupAuthor(String author) {
        TextView newsAuthor = findViewById(R.id.author);
        newsAuthor.setText(author);
    }

    private void setupPublishedAt(Timestamp publishedAt) {
        TextView publishedDate = findViewById(R.id.publish_date);
        publishedDate.setText(DateUtils.getRelativeTimeSpanString(publishedAt.getTime()));
    }

    private void setupContent(String content) {
        TextView newsContent = findViewById(R.id.content);
        newsContent.setText(Html.fromHtml(content, Build.VERSION_CODES.N));
    }

    private void setupOriginalURL(URL url) {
        if (url != null) {
            String link = url.toString();
            TextView originalStory = findViewById(R.id.original_story);
            String originalURL = "<a href=" + link + ">" + ORIGINAL_STORY_CAPTION + "</a>";
            originalStory.setText(Html.fromHtml(originalURL, Build.VERSION_CODES.N));
            originalStory.setMovementMethod(LinkMovementMethod.getInstance());
        }

    }
}