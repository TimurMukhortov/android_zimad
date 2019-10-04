package me.tmukhortov.zimad.domain;

import java.util.List;

import me.tmukhortov.zimad.data.entity.Animal;

public class ApiResponse {
    private final List<Animal> animalList;
    private final Throwable error;

    public ApiResponse(List<Animal> animalList) {
        this.animalList = animalList;
        error = null;
    }

    public ApiResponse(Throwable error) {
        this.error = error;
        animalList = null;
    }
}
