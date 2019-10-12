package me.tmukhortov.zimad.presentation.animal.list.viewmodel;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.Disposable;
import me.tmukhortov.zimad.data.dto.animal.base.Animal;
import me.tmukhortov.zimad.domain.interactor.CatListUseCase;
import me.tmukhortov.zimad.domain.interactor.DogListUseCase;

public class AnimalViewModel extends ViewModel {

    private final CatListUseCase catUseCase;
    private final DogListUseCase dogUseCase;
    private MutableLiveData<List<Animal>> catList;
    private MutableLiveData<List<Animal>> dogList;
    private Disposable disposables;

    public AnimalViewModel() {
        catUseCase = new CatListUseCase();
        // TODO подумать над тем, должен ли этот UseCase жить внутри этой же VM с котятами..
        dogUseCase = new DogListUseCase();
    }

    // TODO избавиться от DTO и вернуть уже Animal, либо его реализацию в данном случае Cat
    public LiveData<List<Animal>> getCatList() {
        if (catList == null) {
            catList = new MutableLiveData<>();
            loadCatList();
        }
        return catList;
    }

    // TODO избавиться от DTO и вернуть уже Animal, либо его реализацию в данном случае Cat
    public LiveData<List<Animal>> getDogList() {
        if (dogList == null) {
            dogList = new MutableLiveData<>();
            loadDogList();
        }
        return dogList;
    }

    // TODO добавить отображение ошибки в тосте или alert(e)
    private void loadCatList() {
        disposables = catUseCase.execute().subscribe(animals -> catList.setValue(animals),
                                                     Throwable::printStackTrace);
    }

    private void loadDogList() {
        // TODO подумать над названиями переменных, туп как-то. Возможно, если UseCase уже будет
        //  возвращать нужные данные, а не dto, проблем решится сама собой, но нужно дать свои
        //  реализации и сделать абстрактный класс Animal
        disposables = dogUseCase.execute().subscribe(animals -> dogList.setValue(animals),
                                                     Throwable::printStackTrace);
    }

    @Override
    protected void onCleared() {
        dispose();
        super.onCleared();
    }

    private void dispose() {
        if (disposables != null && !disposables.isDisposed()) {
            disposables.dispose();
        }
    }
}
