package com.base.appbase.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.base.appbase.activity.BaseActivity;
import com.base.appbase.interfaces.UICallbacks;

/**
 * Created by pnarasimhaiah on 9/2/2016.
 */
public abstract class BaseFragment extends Fragment implements UICallbacks {

    private static final String TAG = BaseFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected void runOnUiThread(Runnable runnable) {
        if (getActivity() != null) {
            ((BaseActivity) getActivity()).processOnUiThread(runnable);
        }
    }

    protected Context getApplicationContext() {
        if (getActivity() != null) {
            return getActivity().getApplicationContext();
        }
        return null;
    }


}
