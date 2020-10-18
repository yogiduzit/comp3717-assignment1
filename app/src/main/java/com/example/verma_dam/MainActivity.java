package com.example.verma_dam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSearchClick(View v) {
        EditText edit = findViewById(R.id.search);
        String s = edit.getText().toString();
        Intent i = new Intent(this, NewsListActivity.class);
        i.putExtra("search", s);
        startActivity(i);
    }
}