package com.base.appbase.dialogs;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.base.appbase.R;

/**
 * Created by pnarasimhaiah on 9/1/2016.
 */
public class LoadingIndicator extends ProgressDialog {

    private String message;
    private TextView messageTV;
    private Context context;


    public LoadingIndicator(Activity activity, int theme) {
        super(activity, theme);
        this.context = activity;
    }

    public LoadingIndicator(Activity activity) {
        super(activity);
        this.context = activity;
    }

    @Override
    public void setMessage(CharSequence message) {
        this.message = message.toString();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        setContentView(R.layout.progress_dialog);
        messageTV = (TextView) findViewById(R.id.progressMessage);
        if (!TextUtils.isEmpty(message)) {
            messageTV.setText(message);
        } else {
            messageTV.setVisibility(View.GONE);
        }
    }

    public void dismiss() {
        super.dismiss();
    }

    public void onConfigurationChanged() {
        init();
    }
}
