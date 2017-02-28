package com.base.appbase.manager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by pnarasimhaiah on 9/29/2016.
 */
public class NetworkConnectivityManager {

    public static boolean isOnline(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        return (info != null) && info.isConnected();
    }

    public static int getConnectionType(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            if (info.getType() == ConnectivityManager.TYPE_WIFI) {
                return ConnectivityManager.TYPE_WIFI;
            } else if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
                return ConnectivityManager.TYPE_MOBILE;
            }
        }
        return -1;
    }
}
