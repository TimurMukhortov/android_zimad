package me.tmukhortov.zimad.domain;

import java.util.List;

import io.reactivex.Single;
import me.tmukhortov.zimad.data.entity.AnimalDto;
import me.tmukhortov.zimad.data.entity.Response;
import me.tmukhortov.zimad.data.repository.AnimalRepository;
import me.tmukhortov.zimad.data.repository.AnimalRepositoryImpl;

public class DogListUseCase {

    private final AnimalRepository animalRepository;

    public DogListUseCase() {
        this.animalRepository = new AnimalRepositoryImpl();
    }

    public Single<List<AnimalDto>> execute() {
        return animalRepository.getDogList().map(Response::getData);
    }
}
