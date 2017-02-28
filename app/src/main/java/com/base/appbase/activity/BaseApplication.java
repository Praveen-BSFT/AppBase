package com.base.appbase.activity;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

import com.base.appbase.config.ServerConfig;
import com.base.appbase.listners.NativeCallStateListener;
import com.base.appbase.logger.Logger;
import com.base.appbase.utils.AndroidUtils;
import com.base.appbase.utils.PreferenceUtils;

/**
 * Created by pnarasimhaiah on 8/30/2016.
 */
public class BaseApplication extends Application implements Application.ActivityLifecycleCallbacks {

    private static final String TAG = BaseApplication.class.getSimpleName();

    private TelephonyManager telephonyManager;

    private NativeCallStateListener nativeCallStateListener;


    @Override
    public void onCreate() {
        super.onCreate();
        intialize();
        configureServerEnvironment();
        nativeCallHandling();

    }


    private void intialize() {

        new Logger(getApplicationContext());
        new AndroidUtils(getApplicationContext());
        new PreferenceUtils(getApplicationContext());

    }

    private void configureServerEnvironment() {
        ServerConfig serverConfig = ServerConfig.getInstance(ServerConfig.SERVER_ENVIRONMENT_DEV);
        serverConfig.confiureServerEnvirnoment(getApplicationContext());
    }

    private void nativeCallHandling() {

        if (AndroidUtils.NATIVE_CALL_HANDLING)
        {
            telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            nativeCallStateListener = NativeCallStateListener.getInstance(getApplicationContext());
            telephonyManager.listen(nativeCallStateListener, PhoneStateListener.LISTEN_CALL_STATE);
        }
    }


    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
