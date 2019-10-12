package me.tmukhortov.zimad.domain.repository;

import io.reactivex.Single;
import me.tmukhortov.zimad.data.dto.animal.Cat;
import me.tmukhortov.zimad.data.dto.animal.Dog;
import me.tmukhortov.zimad.data.dto.response.Response;

public interface AnimalRepository {

    Single<Response<Cat>> getCatList();

    Single<Response<Dog>> getDogList();
}
