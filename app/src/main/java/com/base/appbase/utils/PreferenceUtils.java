package com.base.appbase.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by pnarasimhaiah on 9/1/2016.
 */
public class PreferenceUtils {

    private static Context context;

    private static SharedPreferences sharedPreferences;

    private static SharedPreferences.Editor editor;

    public PreferenceUtils(Context  context)
    {
        this.context = context;
    }

    public static void setPrefDeviceToken(String token)
    {
        if (context == null)
        {
            return;
        }
        SharedPreferences mPref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit = mPref.edit();
        edit.putString("device_token", token);
        edit.commit();

    }

    public static String getPrefDeviceToken()
    {
        SharedPreferences mPref = PreferenceManager.getDefaultSharedPreferences(context);
        String token= mPref.getString("device_token",null);
        return token;
    }
}
