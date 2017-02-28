package com.base.appbase.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.base.appbase.R;
import com.base.appbase.http.BaseRestInterface;
import com.base.appbase.http.HttpManager;
import com.base.appbase.manager.NetworkConnectivityManager;
import com.base.appbase.response.GetResponse;
import com.base.appbase.utils.AndroidUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity implements View.OnClickListener, Callback<GetResponse> {

    Button login;
    private GetResponse getresponse;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(R.layout.activity_login, savedInstanceState);
        init();
    }

    private void init() {
        login = (Button) findViewById(R.id.button);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button:
                //Intent i = new Intent(LoginActivity.this,HomeScreenActivity.class);
                //startActivity(i);
                if (NetworkConnectivityManager.isOnline(this)) {
                    AndroidUtils.showProgressDialog(this, "Loading...");
                    HttpManager.getInstance().CallGetRequest();
                    BaseRestInterface baseRestInterface = HttpManager.getInstance().getRestInterface();
                    if (baseRestInterface != null) {
                        Call<GetResponse> call = baseRestInterface.getRequest();
                        call.enqueue(this);
                    }


                } else {
                    AndroidUtils.showErrorDialog(this, "Network Error", getString(R.string.login), false, null, null);
                }
                break;
        }
    }


    @Override
    public void onResponse(Call<GetResponse> call, Response<GetResponse> response) {
        if (response.isSuccessful() && null != response.body()) {
            getresponse = response.body();
            Toast.makeText(this, getresponse.getStatusMessage(), Toast.LENGTH_LONG).show();
            Intent i = new Intent(LoginActivity.this,HomeScreenActivity.class);
            startActivity(i);
        } else {

            Toast.makeText(this, "Internal server Error", Toast.LENGTH_LONG).show();
        }
        AndroidUtils.dismissProgressDialog();

    }

    @Override
    public void onFailure(Call<GetResponse> call, Throwable t) {

    }
}
