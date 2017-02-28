package com.base.appbase.listners;

import android.content.Context;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;

import com.base.appbase.utils.AndroidUtils;

import java.util.List;

/**
 * Created by pnarasimhaiah on 11/7/2016.
 */

public class NativeCallStateListener extends PhoneStateListener {

    private static NativeCallStateListener instance;

    private Context mContext;

    private NativeCallStateListener(Context mContext)
    {
        super();
        this.mContext = mContext;

    }

    public static synchronized NativeCallStateListener getInstance(Context mContext)
    {
        if (instance == null)
        {
            instance = new NativeCallStateListener(mContext);
        }

        return instance;
    }

    @Override
    public void onCallStateChanged(int state, String incomingNumber)
    {
        // TODO Auto-generated method stub
        super.onCallStateChanged(state, incomingNumber);
        AndroidUtils.handleNativeCall(state);
    }

    @Override
    public void onCallForwardingIndicatorChanged(boolean cfi)
    {
        // TODO Auto-generated method stub
        super.onCallForwardingIndicatorChanged(cfi);
    }

    @Override
    public void onCellInfoChanged(List<CellInfo> cellInfo)
    {
        // TODO Auto-generated method stub
        super.onCellInfoChanged(cellInfo);
    }

    @Override
    public void onCellLocationChanged(CellLocation location)
    {
        // TODO Auto-generated method stub
        super.onCellLocationChanged(location);
    }

    @Override
    public void onDataConnectionStateChanged(int state, int networkType)
    {
        // TODO Auto-generated method stub
        super.onDataConnectionStateChanged(state, networkType);
    }

    @Override
    public void onDataConnectionStateChanged(int state)
    {
        // TODO Auto-generated method stub
        super.onDataConnectionStateChanged(state);
    }

    @Override
    public void onMessageWaitingIndicatorChanged(boolean mwi)
    {
        // TODO Auto-generated method stub
        super.onMessageWaitingIndicatorChanged(mwi);
    }

    @Override
    public void onServiceStateChanged(ServiceState serviceState)
    {
        // TODO Auto-generated method stub
        super.onServiceStateChanged(serviceState);
    }

    @Override
    @Deprecated
    public void onSignalStrengthChanged(int asu)
    {
        // TODO Auto-generated method stub
        super.onSignalStrengthChanged(asu);
    }

    @Override
    public void onSignalStrengthsChanged(SignalStrength signalStrength)
    {
        // TODO Auto-generated method stub
        super.onSignalStrengthsChanged(signalStrength);
    }
}
