package me.tmukhortov.zimad.domain.interactor.base;

import java.util.List;

import io.reactivex.Single;
import me.tmukhortov.zimad.data.repository.AnimalRepositoryImpl;
import me.tmukhortov.zimad.domain.repository.AnimalRepository;

public abstract class AnimalUseCase<T> {

    protected AnimalRepository animalRepository;

    public AnimalUseCase() {
        this.animalRepository = new AnimalRepositoryImpl();
    }

    abstract public Single<List<T>> execute();
}
