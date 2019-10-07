package me.tmukhortov.zimad.domain;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.functions.Function;
import me.tmukhortov.zimad.data.entity.Animal;
import me.tmukhortov.zimad.data.entity.Response;
import me.tmukhortov.zimad.data.repository.AnimalRepository;
import me.tmukhortov.zimad.data.repository.AnimalRepositoryImpl;

public class CatListUseCase {

    private final AnimalRepository animalRepository;

    public CatListUseCase() {
        this.animalRepository = new AnimalRepositoryImpl();
    }

    public Single<List<Animal>> execute() {
        return animalRepository.getCatList().map(new Function<Response<Animal>, List<Animal>>() {
            @Override
            public List<Animal> apply(Response<Animal> animalResponse) throws Exception {
                return animalResponse.getData();
            }
        });
    }
}
