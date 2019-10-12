package me.tmukhortov.zimad.domain.interactor;

import java.util.List;

import io.reactivex.Single;
import me.tmukhortov.zimad.data.dto.animal.Dog;
import me.tmukhortov.zimad.data.dto.response.Response;
import me.tmukhortov.zimad.domain.interactor.base.AnimalUseCase;

public class DogListUseCase extends AnimalUseCase<Dog> {

    @Override
    public Single<List<Dog>> execute() {
        return animalRepository.getDogList().map(Response::getData);
    }
}
