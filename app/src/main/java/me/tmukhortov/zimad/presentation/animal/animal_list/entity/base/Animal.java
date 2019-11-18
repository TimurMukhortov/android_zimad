package me.tmukhortov.zimad.presentation.animal.animal_list.entity.base;

abstract public class Animal {

    private final String avatarPath;
    private final String number;
    private final String description;

    public Animal(String avatarPath, String number, String description) {
        this.avatarPath = avatarPath;
        this.number = number;
        this.description = description;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public String getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }
}
