package com.example.verma_dam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.verma_dam.adapter.NewsItemsAdapter;
import com.example.verma_dam.data.BaseNewsItem;
import com.example.verma_dam.data.NewsItem;
import com.example.verma_dam.http.HttpHandler;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Map;

public class NewsListActivity extends AppCompatActivity {

    private static final String API_KEY = "b4350f204db044389a45332ae2003a66";
    // URL to get news
    private static String SERVICE_URL = "https://newsapi.org/v2/everything?q=bitcoin&from=2020-10-14&sortBy=publishedAt&apiKey=" + API_KEY;

    private String TAG = NewsListActivity.class.getSimpleName();
    private ListView lv;
    private ArrayList<NewsItem> newsItemList;
    private String queryString = "q=";

    /**
     * Async task class to get json by making HTTP call
     */
    private class GetNewsItems extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            String jsonStr = null;

            // Making a request to url and getting response
            jsonStr = sh.makeServiceCall(SERVICE_URL);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                Log.d(TAG, "Json: " + jsonStr);
                // this step is needed to wrap the JSON array inside
                // a JSON object that looks like this { "toons": . . . . }
                Gson gson = new Gson();
                Map response = gson.fromJson(jsonStr, Map.class);

                BaseNewsItem baseNewsItem = gson.fromJson(jsonStr, BaseNewsItem.class);
                newsItemList = baseNewsItem.getNewsItems();
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            NewsItemsAdapter adapter = new NewsItemsAdapter(NewsListActivity.this, newsItemList);

            // Attach the adapter to a ListView
            lv.setAdapter(adapter);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);

        newsItemList = new ArrayList<NewsItem>();
        lv = findViewById(R.id.news_item_list);
        new GetNewsItems().execute();
    }
}