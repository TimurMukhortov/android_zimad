package me.tmukhortov.zimad.data.dto.response;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response<T> {

    @SerializedName("message")
    @Expose
    private final String message;
    @SerializedName("data")
    @Expose
    private final List<T> data;

    public Response(String message, List<T> data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public List<T> getData() {
        return data;
    }
}
