package com.base.appbase.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.base.appbase.R;

/**
 * Created by pnarasimhaiah on 9/2/2016.
 */
public class HomeScreenFragment extends BaseFragment {

    private  View root;

    public static final String TAG = HomeScreenFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_home, null, false);
        bindViews(root);
        return  root;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void bindViews(View root) {

    }

    @Override
    public void bindListeners() {

    }

    @Override
    public void bindData() {

    }

    @Override
    public void requestData() {

    }
}
