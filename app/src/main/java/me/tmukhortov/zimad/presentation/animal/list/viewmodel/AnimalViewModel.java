package me.tmukhortov.zimad.presentation.animal.list.viewmodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.Disposable;
import me.tmukhortov.zimad.domain.entity.animal.base.Animal;
import me.tmukhortov.zimad.domain.interactor.CatListUseCase;
import me.tmukhortov.zimad.domain.interactor.DogListUseCase;
import me.tmukhortov.zimad.domain.interactor.base.BaseAnimalListUseCase;
import me.tmukhortov.zimad.presentation.animal.list.entity.CatView;
import me.tmukhortov.zimad.presentation.animal.list.entity.DogView;
import me.tmukhortov.zimad.presentation.animal.list.entity.base.AnimalView;
import me.tmukhortov.zimad.presentation.base.viewmodel.BaseViewModel;

public class AnimalViewModel<T extends BaseAnimalListUseCase> extends ViewModel
        implements BaseViewModel<List<AnimalView>> {

    private final CatListUseCase catUseCase;
    private final DogListUseCase dogUseCase;
    private MutableLiveData<List<AnimalView>> dataList;
    private MutableLiveData<List<AnimalView>> dogList;
    private Disposable disposables;

    public AnimalViewModel() {
        catUseCase = new CatListUseCase();
        // TODO подумать над тем, должен ли этот UseCase жить внутри этой же VM с котятами..
        dogUseCase = new DogListUseCase();
    }

    public LiveData<List<AnimalView>> getDogList() {
        if (dogList == null) {
            dogList = new MutableLiveData<>();
            loadDogList();
        }
        return dogList;
    }

    // TODO добавить отображение ошибки в тосте или alert(e)

    // TODO добавить обертку над LiveData<List<AnimalView>>, которая также будет содержать Throwable

    // TODO подумать над тем, может ли она содержать состояние загруки, то есть если данные будут
    //  подгружаться постоянно, то будет какое то состояние, которое будет дожидаться

    // TODO надо подумать о том, что getData должен по умолчанию использоваться load и refresh, а
    //  их возможно стоит в абстрактный класс вынести и уже наследоваться от него со своей
    //  реализацей. Пока звучит как хрень. нужно доформулировать мысль.. Либо другой вариант, где
    //  AnimalViewModel наследуется от абстрактного класса. Зачем? При условии что у нас есть
    //  базовый ViewModel. А нужен ли он нам? Хороший вопрос. Надо подумать. В теории мы не
    //  знаем, но если нужна будет другая реализация (хз зачем), то у нас логика на получение
    //  getData будет присутсвовать и в load() и refresh() и тогда получается getData() является
    //  единственной вещью, которую пока нужно будет переопределять в зависимости от реализации.
    //  но пока это только мысль. додумать потом
    private void getData() {
        disposables = catUseCase.executeWithResult().subscribe(animals -> {
            final List<AnimalView> catViewList = new ArrayList<>();
            for (Animal cat : animals) {
                final String number = cat.getNumber();
                final String avatarPath = cat.getAvatarPath();
                final String description = cat.getDescription();
                catViewList.add(new CatView(avatarPath, number, description));
            }
            Collections.shuffle(catViewList);
            dataList.setValue(catViewList);
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

    @Override
    public LiveData<List<AnimalView>> load() {
        if (dataList == null) {
            dataList = new MutableLiveData<>();
            getData();
        }
        return dataList;
    }

    @Override
    public void refresh() {
        getData();
    }
}
