package com.base.appbase.analytics;

/**
 * Created by pnarasimhaiah on 9/1/2016.
 */
public class Analytics {

    public static Analytics instance;

    public Analytics() {

    }

    public Analytics getInstance() {
        if (instance == null) {
            instance = new Analytics();
        }
        return instance;

    }
}

