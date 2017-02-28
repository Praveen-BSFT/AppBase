package com.base.appbase.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by pnarasimhaiah on 9/1/2016.
 */
public class CustomDialog extends Dialog {

    private CustomDialogListner clickListener;

    private int contentViewId;

    private int titleId;

    public CustomDialog(Context context, int contentId,int titleId) {
        super(context);
        this.contentViewId = contentId;
        this.titleId = titleId;
    }

    public void setOnClickListener(CustomDialogListner listener) {
        this.clickListener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (titleId != 0) {
            setTitle(titleId);
        } else {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }

        setContentView(contentViewId);
        if (clickListener != null) {
            clickListener.initializeDialog(this);
            int[] buttonId = clickListener.getButtonIds();
            View b = null;
            for (int id : buttonId) {
                b = findViewById(id);
                if (b instanceof Button) {
                    ((Button) b).setOnClickListener(clickListener);
                } else {
                    b.setOnClickListener(clickListener);
                }
            }
        }
    }
}
