package me.tmukhortov.zimad.data.repository;

import androidx.lifecycle.LiveData;
import me.tmukhortov.zimad.data.response.base.ApiResponse;

public interface AnimalRepository {

    LiveData<ApiResponse> getCatList();

    LiveData<ApiResponse> getDogList();
}
