package com.base.appbase.config;

import android.content.Context;
import android.content.res.Resources;

import com.base.appbase.R;

/**
 * Created by pnarasimhaiah on 8/30/2016.
 */
public class ServerConfig {

    private int serverEnvironment;

    private static ServerConfig instance;

    private static String baseUrl;

    public static final int SERVER_ENVIRONMENT_DEV = 0;

    public static final int SERVER_ENVIRONMENT_QA = 1;

    public static final int SERVER_ENVIRONMENT_STAGE = 2;

    public static final int SERVER_ENVIRONMENT_PROD = 3;

    public ServerConfig(int serverEnvironment) {
        super();
        this.serverEnvironment = serverEnvironment;
    }

    public static synchronized ServerConfig getInstance(int serverEnvironment) {
        if (instance == null) {
            instance = new ServerConfig(serverEnvironment);
        }
        return instance;
    }

    public void confiureServerEnvirnoment(Context context) {
        Resources resources = context.getResources();

        int resID = 0;

        switch (serverEnvironment) {
            case SERVER_ENVIRONMENT_DEV:
                 resID = R.string.base_url_dev;
                break;
            case SERVER_ENVIRONMENT_QA:
                //   resID = R.string.base_url_qa;
                break;
            case SERVER_ENVIRONMENT_STAGE:
                // resID = R.string.base_url_stage;
                break;
            case SERVER_ENVIRONMENT_PROD:
                //  resID = R.string.base_url_prod;
                break;
            default:
                //  resID = R.string.base_url_dev;
                break;
        }

        if (resID != 0) {
            baseUrl = resources.getString(resID);
        }

    }

    public static void setBaseUrl(String serverUrl) {
        baseUrl = serverUrl;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }
}
