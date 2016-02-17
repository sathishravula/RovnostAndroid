package com.ehc.rovnostandroid.app;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import javax.inject.Inject;

public class DeviceManager {

    @Inject
    protected Context context;

    @Inject
    public DeviceManager()
    {
    }

    public boolean checkNetworkConnectivity() {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }

}
