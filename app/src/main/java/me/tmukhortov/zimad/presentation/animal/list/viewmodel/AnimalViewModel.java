package me.tmukhortov.zimad.presentation.animal.list.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import me.tmukhortov.zimad.data.repository.AnimalRepository;
import me.tmukhortov.zimad.data.repository.AnimalRepositoryImpl;
import me.tmukhortov.zimad.data.response.base.ApiResponse;

public class AnimalViewModel extends ViewModel {

    private MediatorLiveData<ApiResponse> apiResponse;
    private AnimalRepository animalRepository;

    public AnimalViewModel() {
        apiResponse = new MediatorLiveData<>();
        animalRepository = new AnimalRepositoryImpl();
    }

    public MediatorLiveData<ApiResponse> getApiResponse() {
        return apiResponse;
    }

    public LiveData<ApiResponse> loadCatList() {
        this.apiResponse.addSource(animalRepository.getCatList(), new Observer<ApiResponse>() {
            @Override
            public void onChanged(ApiResponse apiResponseResponse) {
                apiResponse.setValue(apiResponseResponse);
            }
        });
        return apiResponse;
    }
}
