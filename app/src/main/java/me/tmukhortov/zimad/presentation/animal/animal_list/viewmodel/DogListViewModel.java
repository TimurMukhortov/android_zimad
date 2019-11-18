package me.tmukhortov.zimad.presentation.animal.animal_list.viewmodel;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import io.reactivex.disposables.Disposable;
import me.tmukhortov.zimad.domain.entity.animal.Dog;
import me.tmukhortov.zimad.domain.interactor.animal.DogListUseCase;
import me.tmukhortov.zimad.presentation.animal.animal_list.entity.DogView;
import me.tmukhortov.zimad.presentation.animal.animal_list.entity.base.Animal;
import me.tmukhortov.zimad.presentation.base.viewmodel.BaseViewModelImpl;

public class DogListViewModel extends BaseViewModelImpl<List<Animal>> {

    private final DogListUseCase dogUseCase = new DogListUseCase();
    private Disposable disposables;

    public DogListViewModel() {
        super();
        loadData();
    }

    @Override
    protected void loadData() {
        disposables = dogUseCase.executeWithResult().subscribe(animals -> {
            final List<Animal> dogViewList = new ArrayList<>();
            for (Dog dog : animals) {
                final String number = dog.getNumber();
                final String avatarPath = dog.getAvatarPath();
                final String description = dog.getDescription();
                dogViewList.add(new DogView(avatarPath, number, description));
            }
//            Collections.shuffle(dogViewList);
            getLiveData().setValue(dogViewList);
        }, Throwable::printStackTrace);
    }

    @Override
    public LiveData<List<Animal>> getData() {
        return getLiveData();
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
