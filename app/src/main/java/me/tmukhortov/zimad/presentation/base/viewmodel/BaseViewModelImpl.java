package me.tmukhortov.zimad.presentation.base.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

abstract public class BaseViewModelImpl<T> extends ViewModel implements BaseViewModel<T> {

    private final MutableLiveData<T> liveData;

    public BaseViewModelImpl() {
        liveData = new MutableLiveData<>();
    }

    protected abstract void loadData();

    protected MutableLiveData<T> getLiveData() {
        return liveData;
    }

    @Override
    public void refresh() {
        loadData();
    }
}
