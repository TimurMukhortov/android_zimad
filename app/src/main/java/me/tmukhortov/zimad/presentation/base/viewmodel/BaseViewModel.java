package me.tmukhortov.zimad.presentation.base.viewmodel;

import androidx.lifecycle.LiveData;

public interface BaseViewModel<T> {

    /**
     * Method for update exist data
     */
    void refresh();

    /**
     * Method for return LiveData with held type in current instance
     *
     * @return {@link LiveData<T>}
     */
    LiveData<T> getData();
}
