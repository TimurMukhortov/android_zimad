package me.tmukhortov.zimad.data.dto.animal.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public abstract class Animal {
    @SerializedName("url")
    @Expose
    private final String url;
    @SerializedName("title")
    @Expose
    private final String title;

    public Animal(String url, String title) {
        this.url = url;
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }
}
