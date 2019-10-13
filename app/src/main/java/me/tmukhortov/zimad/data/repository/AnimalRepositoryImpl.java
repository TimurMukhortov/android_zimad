package me.tmukhortov.zimad.data.repository;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.tmukhortov.zimad.data.dto.animal.CatResponse;
import me.tmukhortov.zimad.data.dto.animal.DogResponse;
import me.tmukhortov.zimad.data.dto.response.Response;
import me.tmukhortov.zimad.domain.repository.AnimalRepository;
import me.tmukhortov.zimad.utility.network.NetworkService;

public class AnimalRepositoryImpl implements AnimalRepository {

    @Override
    public Single<Response<CatResponse>> getCatList() {
        return NetworkService.getInstance()
                             .getZimadAPI()
                             .catList()
                             .subscribeOn(Schedulers.single())
                             .observeOn(AndroidSchedulers.mainThread());

    }

    @Override
    public Single<Response<DogResponse>> getDogList() {
        return NetworkService.getInstance()
                             .getZimadAPI()
                             .dogList()
                             .subscribeOn(Schedulers.single())
                             .observeOn(AndroidSchedulers.mainThread());
    }
}
