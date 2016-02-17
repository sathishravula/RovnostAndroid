package com.ehc.rovnostandroid.ui;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ehc.rovnostandroid.R;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private TextInputLayout name;
    private TextInputLayout email;
    private TextInputLayout password;
    private TextInputLayout mobileNo;
    private RelativeLayout register;
    private TextView login;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar.setTitle("Register");
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
//            toolbar.setLogo(R.drawable.ic_navigate_before_white_36dp);
//            actionBar.setIcon(R.drawable.ic_navigate_before_white_36dp);
            setActionBarIcon(R.drawable.ic_navigate_before_white_36dp);
            name = (TextInputLayout) findViewById(R.id.name);
            email = (TextInputLayout) findViewById(R.id.email);
            password = (TextInputLayout) findViewById(R.id.password);
            mobileNo = (TextInputLayout) findViewById(R.id.mobile);
            register=(RelativeLayout)findViewById(R.id.register_layout);
            login=(TextView)findViewById(R.id.login);
            register.setOnClickListener(this);
            login.setOnClickListener(this);


        }

    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_register;
    }

    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch (v.getId()) {
            case R.id.register_layout:
                if (hasFieldsValid()) {
                    Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.login:
                intent=new Intent(this,LoginActivity.class);
                startActivity(intent);
                break;
        }

    }


    private boolean hasFieldsValid() {
        boolean result = true;
        String password = this.password.getEditText().getText().toString().trim();
        String email = this.email.getEditText().getText().toString().trim();
        String name = this.name.getEditText().getText().toString().trim();
        String mobileNo = this.mobileNo.getEditText().getText().toString().trim();
        if (email.isEmpty()) {
            this.email.setError("email should not be empty");
            result = false;
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            this.email.setError("enter a valid email address");
            result = false;
        } else {
            this.email.setErrorEnabled(false);
        }


        if (password.isEmpty()) {
            this.password.setError("password should not be empty");
            result = false;
        } else if (TextUtils.getTrimmedLength(password) < 4) {
            this.password.setError("enter a valid password");
            result = false;
        } else {
            this.password.setErrorEnabled(false);
        }


        if (name.isEmpty()) {
            this.name.setError("name should not be empty");
            result = false;
        }  else {
            this.name.setErrorEnabled(false);
        }


        if (mobileNo.isEmpty()) {
            this.mobileNo.setError("mobile no should not be empty");
            result = false;
        } else if (TextUtils.getTrimmedLength(mobileNo) < 10) {
            this.mobileNo.setError("enter a valid mobile no");
            result = false;
        } else {
            this.mobileNo.setErrorEnabled(false);
        }

        return result;
    }
}
