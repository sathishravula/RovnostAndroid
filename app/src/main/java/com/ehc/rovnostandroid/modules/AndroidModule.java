package com.ehc.rovnostandroid.modules;

import android.content.Context;


import com.ehc.rovnostandroid.app.RovnostApplication;
import com.ehc.rovnostandroid.ui.DashBoardActivity;
import com.ehc.rovnostandroid.ui.DoctorsActivity;
import com.ehc.rovnostandroid.ui.LandingActivity;
import com.ehc.rovnostandroid.ui.LoginActivity;
import com.ehc.rovnostandroid.ui.RegisterActivity;

import dagger.Module;
import dagger.Provides;

@Module(injects = {LoginActivity.class , RegisterActivity.class, LandingActivity.class, DashBoardActivity.class, DoctorsActivity.class}, library = true, complete = false)

public class AndroidModule {

  private RovnostApplication application;

  public AndroidModule(RovnostApplication application) {
    this.application = application;
  }

  @Provides
  public Context provideApplicationContext() {
    return application.getApplicationContext();
  }

  @Provides
  public RovnostApplication provideApplication() {
    return application;
  }

}