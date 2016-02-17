package com.ehc.rovnostandroid.api;

import retrofit.Callback;
import retrofit.RetrofitError;

public abstract class RestCallback<T> implements Callback<T> {
  public abstract void failure(RestError restError);

  @Override
  public void failure(RetrofitError error) {
    if (error.getKind() == RetrofitError.Kind.NETWORK) {
      failure(new RestError("Network Error. Please Check Your Network Connection"));
    }else{
      failure(new RestError(error.getMessage()));
    }

  }
}