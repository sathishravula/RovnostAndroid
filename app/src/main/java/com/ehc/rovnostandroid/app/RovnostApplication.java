package com.ehc.rovnostandroid.app;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;


import com.ehc.rovnostandroid.modules.AndroidModule;
import com.ehc.rovnostandroid.modules.MainModule;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

public class RovnostApplication extends Application {


  private ObjectGraph objectGraph;
  private Account appAccount;


  @Override
  public void onCreate() {
    super.onCreate();
    objectGraph = ObjectGraph.create(getModules().toArray());
//    initImageLoader(getApplicationContext());
//    Bugsnag.init(this);
//    Bugsnag.setReleaseStage("Development");
  }

/*
  public static void initImageLoader(Context context) {
    // This configuration tuning is custom. You can tune every option, you may tune some of them,
    // or you can create default configuration by
    //  ImageLoaderConfiguration.createDefault(this);
    // method.
    ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
    config.threadPriority(Thread.NORM_PRIORITY - 2);
    config.denyCacheImageMultipleSizesInMemory();
//    config.diskCacheExtraOptions(5100,3300,null);
    config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
    config.diskCache(new UnlimitedDiskCache(new File(AppConstants.IMAGES_PATH)));
    config.tasksProcessingOrder(QueueProcessingType.LIFO);
    config.writeDebugLogs(); // Remove for release app

    // Initialize ImageLoader with configuration.
    ImageLoader.getInstance().init(config.build());
  }
*/

  protected List getModules() {
    return Arrays.asList(new MainModule(), new AndroidModule(this));
  }

  public void inject(Object object) {
    objectGraph.inject(object);
  }

  public Object get(Class clazz) {
    return objectGraph.get(clazz);
  }



  protected SharedPreferences getSharedPreferences() {
    SharedPreferences sharedPref = getSharedPreferences(AppConstants.REMS_APP, Context.MODE_PRIVATE);
    return sharedPref;
  }

  public void clearSharedPreferences() {
    SharedPreferences sharedPref = getSharedPreferences(AppConstants.REMS_APP, Context.MODE_PRIVATE);
    sharedPref.edit().clear().commit();
  }

  public void setAuthKey(String authKey) {
    SharedPreferences sharedPreferences = getSharedPreferences();
    sharedPreferences.edit().putString(AppConstants.AUTH_KEY, authKey).commit();
  }

  public String getAuthKey() {
    SharedPreferences sharedPreferences = getSharedPreferences();
    return sharedPreferences.getString(AppConstants.AUTH_KEY, "");
  }

  public void setUserId(String userId) {
    SharedPreferences sharedPreferences = getSharedPreferences();
    sharedPreferences.edit().putString(AppConstants.USER_ID, userId).commit();
  }

  public String getUserId() {
    SharedPreferences sharedPreferences = getSharedPreferences();
    return sharedPreferences.getString(AppConstants.USER_ID, "");
  }


  public void setUserName(String userId) {
    SharedPreferences sharedPreferences = getSharedPreferences();
    sharedPreferences.edit().putString(AppConstants.USER_NAME, userId).commit();
  }

  public String getUserName() {
    SharedPreferences sharedPreferences = getSharedPreferences();
    return sharedPreferences.getString(AppConstants.USER_NAME, "");
  }

  public void setUserRoleId(String userRoleId) {
    SharedPreferences sharedPreferences = getSharedPreferences();
    sharedPreferences.edit().putString(AppConstants.USER_ROLE_ID, userRoleId).commit();
  }

  public String getUserRoleId() {
    SharedPreferences sharedPreferences = getSharedPreferences();
    return sharedPreferences.getString(AppConstants.USER_ROLE_ID, "");
  }


  public String getLoginStatus() {
    SharedPreferences sharedPreferences = getSharedPreferences();
    return sharedPreferences.getString(AppConstants.LOGIN_STATUS, "");
  }

  public void setLoginStatus(String loginStatus) {
    SharedPreferences sharedPreferences = getSharedPreferences();
    sharedPreferences.edit().putString(AppConstants.LOGIN_STATUS, loginStatus).commit();
  }


  public void setCompanyId(String userId) {
    SharedPreferences sharedPreferences = getSharedPreferences();
    sharedPreferences.edit().putString(AppConstants.COMPANY_ID, userId).commit();
  }

  public String getCompanyId() {
    SharedPreferences sharedPreferences = getSharedPreferences();
    return sharedPreferences.getString(AppConstants.COMPANY_ID, "");
  }

  public void setEditPlanSyncStatus(boolean flag) {
    SharedPreferences sharedPreferences = getSharedPreferences();
    sharedPreferences.edit().putBoolean(AppConstants.EDIT_PLAN_SYNC_STATUS, flag).commit();
  }

  public boolean getEditPlanSyncStatus() {
    SharedPreferences sharedPreferences = getSharedPreferences();
    return sharedPreferences.getBoolean(AppConstants.EDIT_PLAN_SYNC_STATUS, false);
  }

  /*public Profile getProfile() {
    SharedPreferences sharedPreferences = getSharedPreferences();
    String profileString = sharedPreferences.getString(AppConstants.BASIC_PROFILE, "");
    Gson gson = new Gson();
    return gson.fromJson(profileString, Profile.class);
  }



  public void saveProfile(Profile model) {
    Gson gson = new Gson();
    String jsonString = gson.toJson(model);
    SharedPreferences sharedPreferences = getSharedPreferences();
    sharedPreferences.edit().putString(AppConstants.BASIC_PROFILE, jsonString).commit();
  }

*/




}
