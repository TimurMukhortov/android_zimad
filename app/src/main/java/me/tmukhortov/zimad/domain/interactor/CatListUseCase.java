package me.tmukhortov.zimad.domain.interactor;

import java.util.List;

import io.reactivex.Single;
import me.tmukhortov.zimad.data.repository.AnimalRepositoryImpl;
import me.tmukhortov.zimad.domain.entity.animal.Cat;
import me.tmukhortov.zimad.domain.interactor.base.BaseUseCase;
import me.tmukhortov.zimad.domain.repository.AnimalRepository;

public class CatListUseCase implements BaseUseCase<Single<List<Cat>>> {

    private AnimalRepository animalRepository;

    public CatListUseCase() {
        this.animalRepository = new AnimalRepositoryImpl();
    }

    @Override
    public Single<List<Cat>> executeWithResult() {
        return animalRepository.getCatList();
    }

    @Override
    public void execute() {
    }
}
