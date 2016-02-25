package com.ehc.rovnostandroid.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ehc.rovnostandroid.R;
import com.gc.materialdesign.views.ButtonRectangle;

public class ChangePassword extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar.setTitle("Change Password");
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
            setActionBarIcon(R.drawable.ic_navigate_before_white_36dp);
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_change_password;
    }
}
