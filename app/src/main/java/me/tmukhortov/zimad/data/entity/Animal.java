package me.tmukhortov.zimad.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class Animal {
    @SerializedName("url")
    @Expose
    private final String mUrl;
    @SerializedName("title")
    @Expose
    private final String mTitle;

    public Animal(String mUrl, String mTitle) {
        this.mUrl = mUrl;
        this.mTitle = mTitle;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getTitle() {
        return mTitle;
    }
}
