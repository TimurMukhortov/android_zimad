package me.tmukhortov.zimad.domain.interactor.animal;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import me.tmukhortov.zimad.domain.entity.animal.Dog;
import me.tmukhortov.zimad.domain.interactor.animal.base.BaseAnimalListUseCase;

public class DogListUseCase extends BaseAnimalListUseCase<Dog> {

    @Override
    public Single<List<Dog>> execute() {
        return animalRepository.getDogList().map(resultList -> {
            final List<Dog> dogList = new ArrayList<>(resultList);
            // TODO make business logic here
            return dogList;
        });
    }
}
