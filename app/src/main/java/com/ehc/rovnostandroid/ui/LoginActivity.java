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


public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private TextInputLayout email;
    private TextInputLayout password;
    private TextView forgotPassword;
    private RelativeLayout login;
    private TextView register;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar.setTitle("Login");
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
            setActionBarIcon(R.drawable.ic_navigate_before_white_36dp);
        }
        email = (TextInputLayout) findViewById(R.id.email);
        password = (TextInputLayout) findViewById(R.id.password);
        forgotPassword = (TextView) findViewById(R.id.forgot_password);
        login = (RelativeLayout) findViewById(R.id.login_layout);
        register = (TextView) findViewById(R.id.register);
        login.setOnClickListener(this);
        register.setOnClickListener(this);
        forgotPassword.setOnClickListener(this);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_login;
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.login_layout:
                intent = new Intent(this, DashBoardActivity.class);
                startActivity(intent);
//                if (hasFieldsValid()) {
//                    Toast.makeText(LoginActivity.this, "success", Toast.LENGTH_SHORT).show();
//                }
                break;
            case R.id.register:
                intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
        }

    }

    private boolean hasFieldsValid() {
        boolean result = true;
        String password = this.password.getEditText().getText().toString().trim();
        String email = this.email.getEditText().getText().toString().trim();
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
        return result;
    }

}
