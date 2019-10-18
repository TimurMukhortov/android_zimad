package me.tmukhortov.zimad.presentation.base.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

abstract public class BaseViewModelImpl<T> extends ViewModel implements BaseViewModel<T> {

    private MutableLiveData<T> liveData;

    protected abstract void getData();

    protected MutableLiveData<T> getLiveData() {
        return liveData;
    }

    @Override
    public LiveData<T> load() {
        if (liveData == null) {
            liveData = new MutableLiveData<>();
            getData();
        }
        return liveData;
    }

    @Override
    public void refresh() {
        if (liveData != null) {
            getData();
        } else {
            throw new NullPointerException("LiveData is null. You can't refresh it.");
        }
    }
}
