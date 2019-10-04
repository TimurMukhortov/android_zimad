package me.tmukhortov.zimad.data.repository;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.tmukhortov.zimad.data.entity.Animal;
import me.tmukhortov.zimad.data.entity.Response;
import me.tmukhortov.zimad.utility.network.NetworkService;

public class AnimalRepositoryImpl implements AnimalRepository {

    @Override
    public Single<Response<Animal>> getCatList() {
        return NetworkService.getInstance()
                             .getZimadAPI()
                             .catList()
                             .subscribeOn(Schedulers.single())
                             .observeOn(AndroidSchedulers.mainThread());

    }
}
