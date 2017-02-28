package com.base.appbase.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pnarasimhaiah on 10/3/2016.
 */
public class BaseHttpResponse {

    private int reqId;

    @SerializedName("status_desc")
    private String statusDescription;

    @SerializedName("status_code")
    private String statusCode;

    @SerializedName("cod_error")
    private String errorCode;

    @SerializedName("des_error")
    private String errorDescription;

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public int getReqId() {
        return reqId;
    }

    public void setReqId(int reqId) {
        this.reqId = reqId;
    }


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String codError) {
        this.errorCode = codError;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String desDescription) {
        this.errorDescription = desDescription;
    }
}
