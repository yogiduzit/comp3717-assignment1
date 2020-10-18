package com.example.verma_dam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Guideline;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int orient = getResources().getConfiguration().orientation;

        ConstraintLayout con = findViewById(R.id.main_constraint_layout);
        Button search = findViewById(R.id.main_search_button);
        Guideline vert40 = findViewById(R.id.vert40);
        Guideline vert50 = findViewById(R.id.vert50);

        ConstraintSet conSet = new ConstraintSet();
        if (orient == Configuration.ORIENTATION_LANDSCAPE) {
            conSet.clone(con);
            conSet.connect(search.getId(), ConstraintSet.TOP, vert50.getId(), ConstraintSet.TOP, 0);
        } else if (orient == Configuration.ORIENTATION_PORTRAIT) {
            conSet.clone(con);
            conSet.connect(search.getId(), ConstraintSet.TOP, vert40.getId(), ConstraintSet.TOP, 0);
        }
        conSet.applyTo(con);
    }

    public void onSearchClick(View v) {
        EditText edit = findViewById(R.id.search);
        String s = edit.getText().toString();
        Intent i = new Intent(this, NewsListActivity.class);
        i.putExtra("search", s);
        startActivity(i);
    }
}