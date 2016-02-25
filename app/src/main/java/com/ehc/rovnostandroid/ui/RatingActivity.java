package com.ehc.rovnostandroid.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ehc.rovnostandroid.R;
import com.ehc.rovnostandroid.adapter.DoctorsAdapter;
import com.ehc.rovnostandroid.adapter.RatingsAdapter;

public class RatingActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        toolbar.setTitle(R.string.rating_screen_title);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
            setActionBarIcon(R.drawable.ic_navigate_before_white_36dp);
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL_LIST));

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        RatingsAdapter mAdapter = new RatingsAdapter(getApplicationContext());
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_rating;
    }
}
