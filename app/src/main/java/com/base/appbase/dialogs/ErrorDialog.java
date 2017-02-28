package com.base.appbase.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.base.appbase.R;

/**
 * Created by pnarasimhaiah on 9/1/2016.
 */
public class ErrorDialog extends Dialog implements DialogInterface.OnKeyListener, View.OnClickListener {


    private FragmentActivity activity;

    private OnClickListener dialogListener;

    private Object tag;

    public ErrorDialog(FragmentActivity activity, int theme) {
        super(activity, theme);
        this.activity = activity;
        init(activity);
    }

    protected ErrorDialog(FragmentActivity activity, boolean cancelable, OnCancelListener cancelListener) {
        super(activity, cancelable, cancelListener);
        this.activity = activity;
        init(activity);
    }

    public ErrorDialog(FragmentActivity activity) {
        super(activity, R.style.AppTheme);
        this.activity = activity;
        init(activity);
    }

    private void init(FragmentActivity activity) {
        this.activity = activity;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.error_dialog);
        setOnKeyListener((OnKeyListener) this);
    }

    public static class Builder {
        private FragmentActivity _activity;

        private TextView messageView;

        private TextView titleView;

        private Button positiveButton;

        private Button negativeButton;

        public Builder(FragmentActivity context) {
            this._activity = context;
        }

        public ErrorDialog create(String title, String message, String positiveButtonStr, String negativeButtonStr) {
            final ErrorDialog dialog = new ErrorDialog(_activity);
            dialog.setOwnerActivity(_activity);
            positiveButton = (Button) dialog.findViewById(R.id.button1);
            positiveButton.setOnClickListener(dialog);
            positiveButton.setId(BUTTON_POSITIVE);

            titleView = (TextView) dialog.findViewById(R.id.uiTitle);
            if (TextUtils.isEmpty(title)) {
                titleView.setVisibility(View.GONE);
            } else {
                titleView.setVisibility(View.VISIBLE);
                titleView.setGravity(Gravity.CENTER);
                titleView.setText(title);
            }

            messageView = (TextView) dialog.findViewById(R.id.uiMessage);
            setMessageText(message);
            return dialog;
        }

        private void setMessageText(String message) {
            if (message == null) {
                return;
            }
            messageView.setText(message);
        }

        private void setPositiveButton(String buttonStr) {
            if (buttonStr == null || TextUtils.isEmpty(buttonStr)) {
                positiveButton.setVisibility(View.GONE);
                return;
            }
            positiveButton.setTextColor(0xFFFFFFFF);
            positiveButton.setVisibility(View.VISIBLE);
            positiveButton.setText(buttonStr);
        }

        private void setNegativeButton(String buttonStr) {
            if (buttonStr == null || TextUtils.isEmpty(buttonStr)) {
                negativeButton.setVisibility(View.GONE);
                return;
            }
            negativeButton.setTextColor(0xFFFFFFFF);
            negativeButton.setVisibility(View.VISIBLE);
            negativeButton.setText(buttonStr);
        }

    }

    public void setOnClickListener(OnClickListener dialogListener) {
        this.dialogListener = dialogListener;
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        if (id == BUTTON_POSITIVE || id == BUTTON_NEGATIVE) {
            if (dialogListener != null) {
                dialogListener.onClick(this, v.getId());
            }
            dismiss();
        } else {
            if (dialogListener != null) {
                dialogListener.onClick(this, v.getId());
            }
        }
    }

    @Override
    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        return false;
    }
}
