package me.tmukhortov.zimad.domain.interactor;

import java.util.List;

import io.reactivex.Single;
import me.tmukhortov.zimad.data.entity.animal.base.Animal;
import me.tmukhortov.zimad.data.entity.response.Response;
import me.tmukhortov.zimad.domain.repository.AnimalRepository;
import me.tmukhortov.zimad.data.repository.AnimalRepositoryImpl;

public class CatListUseCase {

    private final AnimalRepository animalRepository;

    public CatListUseCase() {
        this.animalRepository = new AnimalRepositoryImpl();
    }

    public Single<List<Animal>> execute() {
        return animalRepository.getCatList().map(Response::getData);
    }
}
