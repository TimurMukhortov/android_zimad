package me.tmukhortov.zimad.domain;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import me.tmukhortov.zimad.data.entity.Animal;
import me.tmukhortov.zimad.data.entity.Response;
import me.tmukhortov.zimad.data.repository.AnimalRepository;
import me.tmukhortov.zimad.data.repository.AnimalRepositoryImpl;

public class CatUseCase {

    private final AnimalRepository animalRepository;
    private Disposable disposables;

    public CatUseCase() {
        this.animalRepository = new AnimalRepositoryImpl();
    }

    public void execute() {
        disposables = animalRepository.getCatList().subscribe(new Consumer<Response<Animal>>() {
            @Override
            public void accept(Response<Animal> animalResponse) throws Exception {
                // TODO set data to LiveData<List<Animal>>
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                // TODO show error?
            }
        });
    }

    public void dispose() {
        if (disposables != null && !disposables.isDisposed()) {
            disposables.dispose();
        }
    }
}
