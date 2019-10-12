package me.tmukhortov.zimad.domain.interactor;

import java.util.List;

import io.reactivex.Single;
import me.tmukhortov.zimad.data.dto.animal.Cat;
import me.tmukhortov.zimad.data.dto.response.Response;
import me.tmukhortov.zimad.domain.interactor.base.AnimalUseCase;

public class CatListUseCase extends AnimalUseCase<Cat> {

    @Override
    public Single<List<Cat>> execute() {
        return animalRepository.getCatList().map(Response::getData);
    }
}
