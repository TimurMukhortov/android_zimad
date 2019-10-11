package me.tmukhortov.zimad.domain.entity;

import java.util.List;

import me.tmukhortov.zimad.data.entity.AnimalDto;

public class ApiResponse {
    private final List<AnimalDto> animalList;
    private final Throwable error;

    public ApiResponse(List<AnimalDto> animalList) {
        this.animalList = animalList;
        error = null;
    }

    public ApiResponse(Throwable error) {
        this.error = error;
        animalList = null;
    }
}
