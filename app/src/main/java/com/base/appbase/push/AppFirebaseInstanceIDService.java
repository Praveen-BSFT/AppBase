package com.base.appbase.push;

import android.util.Log;

import com.base.appbase.utils.PreferenceUtils;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by pnarasimhaiah on 10/18/2016.
 */
public class AppFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = AppFirebaseInstanceIDService.class.getSimpleName();

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);
        PreferenceUtils.setPrefDeviceToken(refreshedToken);
        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(String token) {

    }
}
