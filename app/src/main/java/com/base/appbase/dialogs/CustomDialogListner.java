package com.base.appbase.dialogs;

import android.app.Dialog;
import android.view.View;

/**
 * Created by pnarasimhaiah on 9/1/2016.
 */
public interface CustomDialogListner extends View.OnClickListener
{
    public int[] getButtonIds();

    public void initializeDialog(Dialog d);

}
