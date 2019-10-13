package me.tmukhortov.zimad.domain.repository;

import io.reactivex.Single;
import me.tmukhortov.zimad.data.dto.animal.CatResponse;
import me.tmukhortov.zimad.data.dto.animal.DogResponse;
import me.tmukhortov.zimad.data.dto.response.Response;

public interface AnimalRepository {

    Single<Response<CatResponse>> getCatList();

    Single<Response<DogResponse>> getDogList();
}
