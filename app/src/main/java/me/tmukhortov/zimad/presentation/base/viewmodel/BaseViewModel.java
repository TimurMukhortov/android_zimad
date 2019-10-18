package me.tmukhortov.zimad.presentation.base.viewmodel;

import androidx.lifecycle.LiveData;

public interface BaseViewModel<T> {

    /**
     * Method for get data first time after init component
     *
     * @return {@link LiveData} with the specified type held by this instance
     */
    LiveData<T> load();

    /**
     * Method for update exist data
     */
    void refresh();
}
