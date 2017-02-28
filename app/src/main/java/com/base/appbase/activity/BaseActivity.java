package com.base.appbase.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

import com.base.appbase.R;
import com.base.appbase.fragments.DummyFragment;
import com.base.appbase.fragments.HomeScreenFragment;
import com.base.appbase.interfaces.UICallbacks;
import com.base.appbase.utils.AndroidUtils;

import java.util.List;

public class BaseActivity extends AppCompatActivity implements UICallbacks{

    private static final String TAG = BaseActivity.class.getSimpleName();

    private Handler uiHandler;

    private Handler bgHandler;

    protected void onCreate(int layoutId,Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(layoutId);
        uiHandler = new Handler();
        HandlerThread handlerThread = new HandlerThread(TAG + "-BG-Thread", android.os.Process.THREAD_PRIORITY_BACKGROUND);
        handlerThread.start();
        bgHandler = new Handler(handlerThread.getLooper());
        bindViews(null);
        initialize();
        bindListeners();
        //TEST GIT
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

    public void addFragments(final int fragmentID)
    {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                FragmentTransaction fragmentTransaction;
                FragmentManager manager = getSupportFragmentManager();
                fragmentTransaction = manager.beginTransaction();

                switch (fragmentID) {
                    case AndroidUtils.HOME_SCREEN_FRAGMENT_ID:
                        fragmentTransaction.replace(R.id.content_frame, new HomeScreenFragment(), HomeScreenFragment.TAG);
                        break;

                    case AndroidUtils.DUMMY_SCREEN_FRAGMENT_ID:
                         fragmentTransaction.replace(R.id.content_frame, new DummyFragment(), DummyFragment.TAG);
                         break;
                }


            }
        });
    }

    public void removeFragments(String tag)
    {

    }

    public void processOnUiThread(Runnable runnable) {
        if (runnable != null) {
            uiHandler.post(runnable);
        }
    }

    public void processInBgThread(Runnable runnable) {
        if (runnable != null) {
            bgHandler.post(runnable);
        }
    }

    public void checkPermission(String permission, int id) {
        //before calling this method check is Permission granted using AndroidUtils.isPermissionGranted
        ActivityCompat.requestPermissions(this, new String[]{permission}, id);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                if (fragment != null) {
                    fragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
                }
            }
        }
    }
}
