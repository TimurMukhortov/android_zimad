package me.tmukhortov.zimad.domain.interactor.animal;

import java.util.List;

import io.reactivex.Single;
import me.tmukhortov.zimad.data.repository.AnimalRepositoryImpl;
import me.tmukhortov.zimad.domain.entity.animal.Dog;
import me.tmukhortov.zimad.domain.interactor.base.BaseUseCase;
import me.tmukhortov.zimad.domain.repository.AnimalRepository;

public class DogListUseCase implements BaseUseCase<Single<List<Dog>>> {

    private final AnimalRepository animalRepository;

    public DogListUseCase() {
        super();
        animalRepository = new AnimalRepositoryImpl();
    }

    @Override
    public Single<List<Dog>> executeWithResult() {
        // TODO my business logic here
        return animalRepository.getDogList();
    }

    @Override
    public void execute() {
    }
}
