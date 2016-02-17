package com.ehc.rovnostandroid.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.ehc.rovnostandroid.R;

public class LandingActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout loginLayout;
    private RelativeLayout registerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        loginLayout = (RelativeLayout) findViewById(R.id.login_layout);
        registerLayout = (RelativeLayout) findViewById(R.id.register_layout);
        loginLayout.setOnClickListener(this);
        registerLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.login_layout:
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.register_layout:
                intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }
}
