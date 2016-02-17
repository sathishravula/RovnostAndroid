package com.ehc.rovnostandroid.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ehc.rovnostandroid.R;
import com.ehc.rovnostandroid.app.RovnostApplication;
import com.ehc.rovnostandroid.dialog.MyProgressDialogFragment;
import com.ehc.rovnostandroid.dialog.SingleButtonDialogFragment;
import com.google.gson.Gson;

import java.io.File;

import retrofit.client.Response;


/**
 * Created by Sathish on 17/08/15.
 */
public abstract class BaseActivity extends AppCompatActivity {

  protected MyProgressDialogFragment progressDialogFragment;
  protected RovnostApplication application;
  protected Context context;
  protected Toolbar toolbar;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutResource());
    initView();
  }

//  @Override
//  public void onConfigurationChanged(Configuration newConfig) {
//    super.onConfigurationChanged(newConfig);
//    setContentView(getLayoutResource());
//    initView();
//  }

  private void initView() {
    context = this;
    Log.d("test"," "+getApplication().getClass());
    application = (RovnostApplication) getApplication();
    application.inject(this);
    toolbar = (Toolbar) findViewById(R.id.toolbar);
    if (toolbar != null) {
      setSupportActionBar(toolbar);
      getSupportActionBar().setTitle("ROVNOST");
//      getSupportActionBar().setIcon(R.mipmap.ic_launcher);
      getSupportActionBar().setDisplayShowTitleEnabled(true);
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
//    getMenuInflater().inflate(R.menu.menu_base, menu);
    return true;
  }

  @Override
  public boolean onPrepareOptionsMenu(Menu menu) {
    return super.onPrepareOptionsMenu(menu);
  }

  protected abstract int getLayoutResource();

  protected void setActionBarIcon(int iconRes) {
    toolbar.setNavigationIcon(iconRes);
  }

  protected void showProgressDialog(String message) {
    progressDialogFragment = new MyProgressDialogFragment(message);
    FragmentManager fm = getSupportFragmentManager();
    progressDialogFragment.show(fm, MyProgressDialogFragment.class.toString());
  }

  protected void dismissDialog() {
    progressDialogFragment.dismissAllowingStateLoss();
  }

  protected void showErrorDialog(String errorMessage, String title) {
    SingleButtonDialogFragment fragment = new SingleButtonDialogFragment(R.string.ok, errorMessage, title, true);
    FragmentManager fm = getSupportFragmentManager();
    fragment.show(fm, SingleButtonDialogFragment.class.toString());
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    Intent intent;
    switch (item.getItemId()) {
      case android.R.id.home:
        onBackPressed();
        break;
    }
    return super.onOptionsItemSelected(item);
  }


  @Override
  protected void onDestroy() {
    super.onDestroy();
  }
}