package me.tmukhortov.zimad.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class AnimalDto {
    @SerializedName("url")
    @Expose
    private final String url;
    @SerializedName("title")
    @Expose
    private final String title;

    public AnimalDto(String url, String title) {
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
