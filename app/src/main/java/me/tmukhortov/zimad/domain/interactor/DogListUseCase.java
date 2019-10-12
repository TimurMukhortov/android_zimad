package me.tmukhortov.zimad.domain.interactor;

import java.util.List;

import io.reactivex.Single;
import me.tmukhortov.zimad.data.entity.animal.base.Animal;
import me.tmukhortov.zimad.data.entity.response.Response;
import me.tmukhortov.zimad.domain.repository.AnimalRepository;
import me.tmukhortov.zimad.data.repository.AnimalRepositoryImpl;

public class DogListUseCase {

    private final AnimalRepository animalRepository;

    public DogListUseCase() {
        this.animalRepository = new AnimalRepositoryImpl();
    }

    public Single<List<Animal>> execute() {
        return animalRepository.getDogList().map(Response::getData);
    }
}
