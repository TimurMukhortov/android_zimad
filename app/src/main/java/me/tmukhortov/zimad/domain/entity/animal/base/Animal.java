package me.tmukhortov.zimad.domain.entity.animal.base;

public abstract class Animal {

    private final String number;
    private final String avatarPath;
    private final String description;

    public Animal(String number, String description, String avatarPath) {
        this.number = number;
        this.avatarPath = avatarPath;
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public String getDescription() {
        return description;
    }
}
