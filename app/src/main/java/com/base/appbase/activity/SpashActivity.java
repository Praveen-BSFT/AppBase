package com.base.appbase.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.base.appbase.R;

public class SpashActivity extends BaseActivity {

    private static final String TAG = SpashActivity.class.getSimpleName();

    private Handler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(R.layout.activity_spash,savedInstanceState);
        splashScreenTime();
    }

    private void splashScreenTime() {
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SpashActivity.this,LoginActivity.class);
                startActivity(i);
                finish();
            }
        },2000);
    }
}


