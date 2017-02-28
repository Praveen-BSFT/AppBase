package com.base.appbase.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by pnarasimhaiah on 10/3/2016.
 */
public class Dummy implements Serializable {

    @SerializedName("content")
    private String content;

    @SerializedName("title")
    private String title;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
