package me.tmukhortov.zimad.presentation.animal.list.viewmodel;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.Disposable;
import me.tmukhortov.zimad.domain.entity.animal.base.Animal;
import me.tmukhortov.zimad.domain.interactor.CatListUseCase;
import me.tmukhortov.zimad.domain.interactor.DogListUseCase;
import me.tmukhortov.zimad.presentation.animal.list.entity.CatView;
import me.tmukhortov.zimad.presentation.animal.list.entity.DogView;
import me.tmukhortov.zimad.presentation.animal.list.entity.base.AnimalView;

public class AnimalViewModel extends ViewModel {

    private final CatListUseCase catUseCase;
    private final DogListUseCase dogUseCase;
    private MutableLiveData<List<AnimalView>> catList;
    private MutableLiveData<List<AnimalView>> dogList;
    private Disposable disposables;

    public AnimalViewModel() {
        catUseCase = new CatListUseCase();
        // TODO подумать над тем, должен ли этот UseCase жить внутри этой же VM с котятами..
        dogUseCase = new DogListUseCase();
    }

    public LiveData<List<AnimalView>> getCatList() {
        if (catList == null) {
            catList = new MutableLiveData<>();
            loadCatList();
        }
        return catList;
    }

    public LiveData<List<AnimalView>> getDogList() {
        if (dogList == null) {
            dogList = new MutableLiveData<>();
            loadDogList();
        }
        return dogList;
    }

    // TODO добавить отображение ошибки в тосте или alert(e)
    private void loadCatList() {
        disposables = catUseCase.execute().subscribe(animals -> {
            final List<AnimalView> catViewList = new ArrayList<>();
            for (Animal cat : animals) {
                final String number = cat.getNumber();
                final String avatarPath = cat.getAvatarPath();
                final String description = cat.getDescription();
                catViewList.add(new CatView(avatarPath, number, description));
            }
            catList.setValue(catViewList);
        }, Throwable::printStackTrace);
    }

    private void loadDogList() {
        disposables = dogUseCase.execute().subscribe(animals -> {
            final List<AnimalView> dogViewList = new ArrayList<>();
            for (Animal dog : animals) {
                final String number = dog.getNumber();
                final String avatarPath = dog.getAvatarPath();
                final String description = dog.getDescription();
                dogViewList.add(new DogView(avatarPath, number, description));
            }
            dogList.setValue(dogViewList);
        }, Throwable::printStackTrace);
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
