package me.tmukhortov.zimad.presentation.animal.list.viewmodel;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import me.tmukhortov.zimad.data.entity.Animal;
import me.tmukhortov.zimad.domain.ApiResponse;
import me.tmukhortov.zimad.domain.CatUseCase;

public class AnimalViewModel extends ViewModel {

    private MediatorLiveData<ApiResponse> apiResponse;
    private final CatUseCase catUseCase;

    public AnimalViewModel() {
        //        apiResponse = new MediatorLiveData<>();
        catUseCase = new CatUseCase();
    }

    public MediatorLiveData<ApiResponse> getApiResponse() {
        return apiResponse;
    }

    private MutableLiveData<List<Animal>> catList;

    public LiveData<List<Animal>> getCatList() {
        if (catList == null) {
            catList = new MutableLiveData<>();
            catUseCase.execute();
        }
        return catList;
    }
}
