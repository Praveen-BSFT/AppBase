package com.base.appbase.manager;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.PowerManager;

/**
 * Created by pnarasimhaiah on 11/7/2016.
 */

public class BaseManager implements SensorEventListener {


    private final Context mContext;

    private PowerManager.WakeLock proxSensorWakeLock;//for call related

    private int field = 0x00000020;

    private PowerManager powerManager;

    private SensorManager mSensorManager;

    private Sensor mSensor;


    public BaseManager(Context context) {
        mContext = context;
    }

    public void releaseOncallWakeLock() {
        if (proxSensorWakeLock != null && proxSensorWakeLock.isHeld()) {
            proxSensorWakeLock.release();
        }
        proxSensorWakeLock = null;

    }

    public void acquireOncallWakeLock() {
        if ((proxSensorWakeLock == null || !proxSensorWakeLock.isHeld())) {
            try {
                field = PowerManager.class.getClass().getField("PROXIMITY_SCREEN_OFF_WAKE_LOCK").getInt(null);
            } catch (Throwable ignored) {
            }
            powerManager = ((PowerManager) mContext.getSystemService(Context.POWER_SERVICE));
            if (proxSensorWakeLock == null) {
                proxSensorWakeLock = powerManager.newWakeLock(field, "Oncall");
                proxSensorWakeLock.acquire();
            }
        }
    }

    public void sensorUnregisterListener() {
        mSensorManager.unregisterListener(this);
    }

    public void sensorRegisterListener() {
        mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
