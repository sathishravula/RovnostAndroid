package com.ehc.rovnostandroid.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ehc.rovnostandroid.R;

public class ForgotPassword extends BaseActivity implements View.OnClickListener {

    private TextView submit;
    private TextView resend;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar.setTitle("Forgot Password");
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
            setActionBarIcon(R.drawable.ic_navigate_before_white_36dp);
            submit =(TextView)findViewById(R.id.submit);
            resend =(TextView)findViewById(R.id.resend);
            submit.setOnClickListener(this);
            resend.setOnClickListener(this);
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_forgot_password;
    }

    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch (v.getId()){
            case R.id.resend:
                 intent=new Intent(this,LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.submit:
                Toast.makeText(getApplicationContext(), "OTP sent to ur email", Toast.LENGTH_SHORT).show();
                break;

        }

    }
}
