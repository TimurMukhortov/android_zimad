package me.tmukhortov.zimad.presentation.animal.list.viewmodel;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import me.tmukhortov.zimad.data.entity.Animal;
import me.tmukhortov.zimad.domain.CatUseCase;
import me.tmukhortov.zimad.presentation.animal.list.livedata.AnimalLiveData;

public class AnimalViewModel extends ViewModel {

    private final CatUseCase catUseCase;
    private Disposable disposables;
    private AnimalLiveData catList;

    public AnimalViewModel() {
        catUseCase = new CatUseCase();
    }

    public AnimalLiveData getCatList() {
        if (catList == null) {
            catList = new AnimalLiveData();
            loadCatList();
        }
        return catList;
    }

    private void loadCatList() {
        disposables = catUseCase.execute().subscribe(new Consumer<List<Animal>>() {
            @Override
            public void accept(List<Animal> animals) throws Exception {
                MutableLiveData<List<Animal>> mutableLiveData = new MutableLiveData<>();
                mutableLiveData.postValue(animals);
                catList.setAnimalList(mutableLiveData);
            }
        });
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
