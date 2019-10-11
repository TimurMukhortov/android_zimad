package me.tmukhortov.zimad.data.repository;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.tmukhortov.zimad.data.entity.AnimalDto;
import me.tmukhortov.zimad.data.entity.Response;
import me.tmukhortov.zimad.utility.network.NetworkService;

public class AnimalRepositoryImpl implements AnimalRepository {

    @Override
    public Single<Response<AnimalDto>> getCatList() {
        return NetworkService.getInstance()
                             .getZimadAPI()
                             .catList()
                             .subscribeOn(Schedulers.single())
                             .observeOn(AndroidSchedulers.mainThread());

    }

    @Override
    public Single<Response<AnimalDto>> getDogList() {
        return NetworkService.getInstance()
                             .getZimadAPI()
                             .dogList()
                             .subscribeOn(Schedulers.single())
                             .observeOn(AndroidSchedulers.mainThread());
    }
}
