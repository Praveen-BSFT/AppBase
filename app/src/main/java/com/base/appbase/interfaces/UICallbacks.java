package com.base.appbase.interfaces;

import android.view.View;

/**
 * Created by pnarasimhaiah on 9/1/2016.
 */
public interface UICallbacks {

    void initialize();

    void bindViews(View root);

    void bindListeners();

    void bindData();

    void requestData();
}
