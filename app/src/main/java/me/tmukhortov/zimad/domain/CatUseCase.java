package me.tmukhortov.zimad.domain;

import me.tmukhortov.zimad.data.repository.AnimalRepository;

public class CatUseCase {

    private final AnimalRepository animalRepository;

    CatUseCase(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }
tus

    public void execute() {
        animalRepository.getCatList();
    }

//    public void dispose() {
    //        if (!disposables.isDisposed()) {
    //            disposables.dispose();
    //        }
    //    }
}
