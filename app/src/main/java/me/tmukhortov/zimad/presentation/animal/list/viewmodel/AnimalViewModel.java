package me.tmukhortov.zimad.presentation.animal.list.viewmodel;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import me.tmukhortov.zimad.data.entity.Animal;
import me.tmukhortov.zimad.domain.CatUseCase;

public class AnimalViewModel extends ViewModel {

    private final CatUseCase catUseCase;
    private MutableLiveData<List<Animal>> catList;
    private Disposable disposables;

    public AnimalViewModel() {
        catUseCase = new CatUseCase();
    }

    public LiveData<List<Animal>> getCatList() {
        if (catList == null) {
            catList = new MutableLiveData<>();
            loadCatList();
        }
        return catList;
    }

    private void loadCatList() {
        disposables = catUseCase.execute().subscribe(new Consumer<List<Animal>>() {
            @Override
            public void accept(List<Animal> animals) throws Exception {
                catList.setValue(animals);
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
