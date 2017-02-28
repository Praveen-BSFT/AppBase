package com.base.appbase.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.base.appbase.BuildConfig;
import com.base.appbase.R;
import com.base.appbase.dialogs.ErrorDialog;
import com.base.appbase.dialogs.LoadingIndicator;

/**
 * Created by pnarasimhaiah on 9/1/2016.
 */
public class AndroidUtils {

    private static Context context;

    private static LoadingIndicator loadingIndicator;

    public static Dialog customDialog;

    public static final String USER_AGENT_DELIMITER = ":";

    public static final int HOME_SCREEN_FRAGMENT_ID = 1001;

    public static final int DUMMY_SCREEN_FRAGMENT_ID = 1002;

    public static final String SUCCESS_INDICATOR = "S";

    public static boolean NATIVE_CALL_HANDLING = false;

    private static int nativeCallState = 0;

    public AndroidUtils(Context context)
    {
        this.context = context;
    }


    public static void showProgressDialog(Activity activity, String message) {
        startLoadingIndicator(activity, true, false, message);
    }


    public static void dismissProgressDialog() {
        stopLoadingIndicator();
    }

    private static void startLoadingIndicator(final Activity activity, boolean isCancellable, boolean background, String message) {
        if (loadingIndicator != null) {
            if (loadingIndicator.isShowing()) {
                return;
            }
        }
        stopLoadingIndicator();

        String msg = "";
        if (message != null) {
            msg = message;
        }
        loadingIndicator = new LoadingIndicator(activity);
        loadingIndicator.setTitle(null);
        loadingIndicator.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        loadingIndicator.setMessage(msg);
        loadingIndicator.setIndeterminate(false);
        loadingIndicator.setCancelable(isCancellable);
        loadingIndicator.setCanceledOnTouchOutside(false);
        loadingIndicator.setOnDismissListener(new DialogInterface.OnDismissListener() {

            @Override
            public void onDismiss(DialogInterface dialog) {

            }
        });
        loadingIndicator.show();
    }

    private static void startLoadingIndicatorTimerDialog(final Activity activity, boolean isCancellable, boolean background, String message,int timer) {
        if (loadingIndicator != null) {
            if (loadingIndicator.isShowing()) {
                return;
            }
        }
        stopLoadingIndicator();

        String msg = "";
        if (message != null) {
            msg = message;
        }
        loadingIndicator = new LoadingIndicator(activity);
        loadingIndicator.setTitle(null);
        loadingIndicator.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        loadingIndicator.setMessage(msg);
        loadingIndicator.setIndeterminate(false);
        loadingIndicator.setCancelable(isCancellable);
        loadingIndicator.setCanceledOnTouchOutside(false);
        loadingIndicator.setOnDismissListener(new DialogInterface.OnDismissListener() {

            @Override
            public void onDismiss(DialogInterface dialog) {

            }
        });
        loadingIndicator.show();

        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                stopLoadingIndicator();
            }
        },timer);
    }

    private static void stopLoadingIndicator() {
        try {
            if (loadingIndicator != null && loadingIndicator.isShowing()) {
                loadingIndicator.dismiss();
                loadingIndicator = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static String getApplicationVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static void showErrorDialog(final FragmentActivity activity, String message, String title, boolean isCancelableOutside, DialogInterface.OnClickListener onClickListener, DialogInterface.OnCancelListener onCancelListener) {
        try {

            if (activity == null) {
                return;
            }
            if (loadingIndicator != null && loadingIndicator.isShowing()) {
                loadingIndicator.dismiss();
                loadingIndicator = null;
            }
            if (customDialog != null && customDialog.isShowing()) {
                customDialog.dismiss();
                customDialog = null;
            }

            ErrorDialog.Builder ab = new ErrorDialog.Builder(activity);
            customDialog = ab.create(title, message, context.getString(R.string.ok), null);

            if (onCancelListener != null) {
                customDialog.setOnCancelListener(onCancelListener);
            }

            ((ErrorDialog) customDialog).setOnClickListener(onClickListener);

            if (isCancelableOutside) {
                customDialog.setCanceledOnTouchOutside(true);
            } else {
                customDialog.setCanceledOnTouchOutside(false);
            }

            customDialog.show();

        } catch (Exception ex) {

        }

    }

    public static void dismissErrorDialog() {
        if (customDialog != null) {
            customDialog.dismiss();
        }
    }

    public static boolean isPermissionGranted(Context context, String permission) {
        if (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        return false;
    }

    public static String getUserAgent() {
        return context.getString(R.string.app_name) + USER_AGENT_DELIMITER + BuildConfig.VERSION_NAME + USER_AGENT_DELIMITER + context.getString(R.string.android) + USER_AGENT_DELIMITER + context.getApplicationInfo().targetSdkVersion + USER_AGENT_DELIMITER + getScreenResolution() + USER_AGENT_DELIMITER + getDeviceName();
    }

    private static String getScreenResolution() {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        return width + "x" + height;
    }

    public static String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return capitalize(model);
        } else {
            return capitalize(manufacturer) + model;
        }
    }

    private static String capitalize(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char first = s.charAt(0);
        if (Character.isUpperCase(first)) {
            return s;
        } else {
            return Character.toUpperCase(first) + s.substring(1);
        }
    }

    public static void handleNativeCall(int state)
    {
        nativeCallState = state;
        switch (nativeCallState)
        {
            case TelephonyManager.CALL_STATE_IDLE:
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                break;
            case TelephonyManager.CALL_STATE_RINGING:
                break;
        }

    }
}
