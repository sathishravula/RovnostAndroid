package com.ehc.rovnostandroid.ui;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.ehc.rovnostandroid.R;
import com.gc.materialdesign.views.ButtonRectangle;

public class LandingActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout loginLayout;
    private RelativeLayout registerLayout;
    private ButtonRectangle login;
    private ButtonRectangle register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        login = (ButtonRectangle) findViewById(R.id.login);
        register = (ButtonRectangle) findViewById(R.id.register);
//        loginLayout = (RelativeLayout) findViewById(R.id.login_layout);
//        registerLayout = (RelativeLayout) findViewById(R.id.register_layout);
//        login.setTextColor(Color.BLUE);
        Log.d("Text11",""+login);
        Log.d("Text11",""+login.getTextView());
//        login.setTextColor(Color.GRAY);
//        Log.d("Text11",""+login.getTextView().setTextColor(Color.BLACK););
//        login.setTextColor(getResources().getColor(R.color.dental_grid_color));
        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.login:
                intent = new Intent(this, MyProfile.class);
                startActivity(intent);
                break;
            case R.id.register:
                intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }
}
