package com.base.appbase.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pnarasimhaiah on 11/3/2016.
 */

public class GetResponse extends BaseHttpResponse {



    @SerializedName("statusCode")
    private String statusCode;

    @SerializedName("statusMessage")
    private String statusMessage;

    @SerializedName("fullSyncUrl")
    private String fullSyncUrl;

    @SerializedName("syncFreq")
    private String syncFreq;

    @SerializedName("syncTime")
    private String syncTime;


    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }


    public String getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(String syncTime) {
        this.syncTime = syncTime;
    }

    public String getSyncFreq() {
        return syncFreq;
    }

    public void setSyncFreq(String syncFreq) {
        this.syncFreq = syncFreq;
    }

    public String getFullSyncUrl() {
        return fullSyncUrl;
    }

    public void setFullSyncUrl(String fullSyncUrl) {
        this.fullSyncUrl = fullSyncUrl;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

}
