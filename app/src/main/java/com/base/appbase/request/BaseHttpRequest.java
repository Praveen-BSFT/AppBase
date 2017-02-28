package com.base.appbase.request;

/**
 * Created by pnarasimhaiah on 10/3/2016.
 */
public class BaseHttpRequest {

    private String appVersion;

    private String deviceId;

    private String osType;

    /*public BaseHttpRequest(String appVersion, String deviceId, String osType)
    {
        this.appVersion = appVersion;
        this.deviceId = deviceId;
        this.osType = osType;
    }*/

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }
}
