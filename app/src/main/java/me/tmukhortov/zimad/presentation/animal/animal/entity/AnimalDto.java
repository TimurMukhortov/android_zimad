package me.tmukhortov.zimad.presentation.animal.animal.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class AnimalDto implements Parcelable {

    private String avatarPath;
    private String number;
    private String description;

    public AnimalDto(String avatarPath, String number, String description) {
        this.avatarPath = avatarPath;
        this.number = number;
        this.description = description;
    }

    public AnimalDto(Parcel in) {
        String[] data = new String[3];
        in.readStringArray(data);
        avatarPath = data[0];
        number = data[1];
        description = data[2];
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {avatarPath, number, description});
    }

    public static final Parcelable.Creator<AnimalDto> CREATOR =
            new Parcelable.Creator<AnimalDto>() {

                @Override
                public AnimalDto createFromParcel(Parcel source) {
                    return new AnimalDto(source);
                }

                @Override
                public AnimalDto[] newArray(int size) {
                    return new AnimalDto[size];
                }
            };
}
