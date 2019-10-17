package me.tmukhortov.zimad.domain.interactor;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import me.tmukhortov.zimad.domain.entity.animal.Cat;
import me.tmukhortov.zimad.domain.interactor.base.BaseAnimalListUseCase;

public class CatListUseCase extends BaseAnimalListUseCase<Cat> {

    @Override
    public Single<List<Cat>> execute() {
        return animalRepository.getCatList().map(resultList -> {
            List<Cat> catList = new ArrayList<>(resultList);
            // TODO make business logic here
            return catList;
        });
    }
}
