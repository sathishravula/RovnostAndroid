package com.ehc.rovnostandroid.modules;

import android.content.Context;


import com.ehc.rovnostandroid.app.RovnostApplication;
import com.ehc.rovnostandroid.ui.ChangePassword;
import com.ehc.rovnostandroid.ui.ConfirmationActivity;
import com.ehc.rovnostandroid.ui.DashBoardActivity;
import com.ehc.rovnostandroid.ui.DoctorsActivity;
import com.ehc.rovnostandroid.ui.ForgotPassword;
import com.ehc.rovnostandroid.ui.LandingActivity;
import com.ehc.rovnostandroid.ui.LoginActivity;
import com.ehc.rovnostandroid.ui.MyProfile;
import com.ehc.rovnostandroid.ui.RegisterActivity;
import com.ehc.rovnostandroid.ui.RequestConsultationActivity;

import dagger.Module;
import dagger.Provides;

@Module(injects = {LoginActivity.class , RegisterActivity.class, LandingActivity.class, ChangePassword.class,ForgotPassword.class,DashBoardActivity.class, DoctorsActivity.class, RequestConsultationActivity.class, ConfirmationActivity.class, MyProfile.class}, library = true, complete = false)

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