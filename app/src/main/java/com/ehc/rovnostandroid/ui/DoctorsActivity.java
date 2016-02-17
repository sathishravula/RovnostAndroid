package com.ehc.rovnostandroid.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import com.ehc.rovnostandroid.R;

public class DoctorsActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar.setTitle("Available Doctors");
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
            setActionBarIcon(R.drawable.ic_navigate_before_white_36dp);
        }
    }
    @Override
    protected int getLayoutResource() {
        return R.layout.activity_doctors;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.notification_menu, menu);
        return true;
    }
}


