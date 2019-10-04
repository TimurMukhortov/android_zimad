package me.tmukhortov.zimad.data.repository;

import io.reactivex.Single;
import me.tmukhortov.zimad.data.entity.Animal;
import me.tmukhortov.zimad.data.entity.Response;

public interface AnimalRepository {

    Single<Response<Animal>> getCatList();
}
