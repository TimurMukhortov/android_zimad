package me.tmukhortov.zimad.presentation.animal.list.entity;

import android.net.Uri;

public class Animal {

    private final String avatarPath;
    private final String title;

    public Animal(String avatarPath, String title) {
        this.avatarPath = avatarPath;
        this.title = title;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public String getTitle() {
        return title;
    }
}
