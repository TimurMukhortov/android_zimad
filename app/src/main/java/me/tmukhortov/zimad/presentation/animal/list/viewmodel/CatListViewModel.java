package me.tmukhortov.zimad.presentation.animal.list.viewmodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.disposables.Disposable;
import me.tmukhortov.zimad.domain.entity.animal.Cat;
import me.tmukhortov.zimad.domain.interactor.animal.CatListUseCase;
import me.tmukhortov.zimad.presentation.animal.list.entity.CatView;
import me.tmukhortov.zimad.presentation.animal.list.entity.base.AnimalView;
import me.tmukhortov.zimad.presentation.base.viewmodel.BaseViewModelImpl;

// TODO говно то, что UI не блокируется и можно будет Refresh сразу сделать.. Надо подумать,
//  может ли быть такое, что ты первый раз заходишь данные загружаются в BackGround потоке, а
//  потом такой в UI еще refresh данных прросишь сделать и с refresh() данные приходят
//  актуальные, а с load() потом приходят уже старые
public class CatListViewModel extends BaseViewModelImpl<List<AnimalView>> {

    private final CatListUseCase catUseCase = new CatListUseCase();
    private Disposable disposables;

    public CatListViewModel() {
        super();
        loadData();
    }

    @Override
    protected void loadData() {
        disposables = catUseCase.executeWithResult().subscribe(animals -> {
            final List<AnimalView> catViewList = new ArrayList<>();
            for (Cat cat : animals) {
                final String number = cat.getNumber();
                final String avatarPath = cat.getAvatarPath();
                final String description = cat.getDescription();
                catViewList.add(new CatView(avatarPath, number, description));
            }
            Collections.shuffle(catViewList);
            getData().setValue(catViewList);
        }, Throwable::printStackTrace);
    }

    @Override
    public MutableLiveData<List<AnimalView>> getData() {
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