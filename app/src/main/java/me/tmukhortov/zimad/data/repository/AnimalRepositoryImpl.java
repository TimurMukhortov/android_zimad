package me.tmukhortov.zimad.data.repository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import me.tmukhortov.zimad.data.response.Animal;
import me.tmukhortov.zimad.data.response.Response;
import me.tmukhortov.zimad.data.response.base.ApiResponse;
import me.tmukhortov.zimad.utility.network.NetworkService;

public class AnimalRepositoryImpl implements AnimalRepository {

    @Override
    public LiveData<ApiResponse> getCatList() {
        final MutableLiveData<ApiResponse> liveData = new MutableLiveData<>();
        NetworkService.getInstance().getZimadAPI().catList().subscribeOn(Schedulers.single())
                      .observeOn(AndroidSchedulers.mainThread())
                      .subscribe(new SingleObserver<Response<Animal>>() {
                          @Override
                          public void onSubscribe(Disposable d) {
                          }

                          @Override
                          public void onSuccess(Response<Animal> response) {
                              List<Animal> animalList = response.getData();
                              liveData.setValue(new ApiResponse(animalList));
                          }

                          @Override
                          public void onError(Throwable e) {
                              liveData.setValue(new ApiResponse(e));
                          }
                      });
        return liveData;
    }

    @Override
    public LiveData<ApiResponse> getDogList() {
        return null;
    }
}
