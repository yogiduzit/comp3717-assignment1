package com.example.verma_dam.adapter;


import android.app.Activity;
import android.content.Context;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.verma_dam.data.NewsItem;

import java.util.ArrayList;

import com.example.verma_dam.R;

public class NewsItemsAdapter extends ArrayAdapter<NewsItem> {

    Context _context;
    public NewsItemsAdapter(Context context, ArrayList<NewsItem> newsItems) {
        super(context, 0, newsItems);
        _context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Activity activity = (Activity) _context;
        // Get the data item for this position
        NewsItem newsItem = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_news_item, parent, false);
        }

        // Lookup view for data population
        TextView newsTitle = convertView.findViewById(R.id.title);
        TextView newsDescription = convertView.findViewById(R.id.timestamp);

        // Populate the data into the template view using the data object
        newsTitle.setText(String.format("%s", newsItem.getTitle()));
        newsDescription.setText(DateUtils.getRelativeTimeSpanString(newsItem.getPublishedAt().getTime()));

        ImageView imgOnePhoto = convertView.findViewById(R.id.thumbImage);
        String imgURL = newsItem.getUrltoImage();
        if (imgURL != null) {
            Glide.with(getContext())
                    .load(imgURL)
                    .into(imgOnePhoto);

        }

        // Return the completed view to render on screen
        return convertView;
    }
}

