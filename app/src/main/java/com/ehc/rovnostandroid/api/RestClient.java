package com.ehc.rovnostandroid.api;


import com.ehc.rovnostandroid.app.AppConstants;
import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

public class RestClient {

  private static RestApi REST_CLIENT;

  static {
    setupRestClient();
  }

  public static RestApi get() {
    return REST_CLIENT;
  }

  private static void setupRestClient() {


    RestAdapter restAdapter = new RestAdapter.Builder()
        .setLogLevel(RestAdapter.LogLevel.FULL)
        .setEndpoint(AppConstants.WEBSERVICE_BASE_URL)
        .setClient(new OkClient(new OkHttpClient()))
        .build();

    REST_CLIENT = restAdapter.create(RestApi.class);
  }
}