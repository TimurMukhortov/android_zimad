package me.tmukhortov.zimad.domain.repository;

import java.util.List;

import io.reactivex.Single;
import me.tmukhortov.zimad.domain.entity.animal.Cat;
import me.tmukhortov.zimad.domain.entity.animal.Dog;

public interface AnimalRepository {

    Single<List<Cat>> getCatList();

    Single<List<Dog>> getDogList();
}
