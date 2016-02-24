package com.ehc.rovnostandroid.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ehc.rovnostandroid.R;

public class ConfirmationActivity extends BaseActivity implements View.OnClickListener {

    private TextView dashboard;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar.setTitle("Confirmation");
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
            setActionBarIcon(R.drawable.ic_navigate_before_white_36dp);
            dashboard=(TextView)findViewById(R.id.dashboard);
            dashboard.setOnClickListener(this);
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_confirmation2;
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this,DashBoardActivity.class);
        startActivity(intent);
            }

}
