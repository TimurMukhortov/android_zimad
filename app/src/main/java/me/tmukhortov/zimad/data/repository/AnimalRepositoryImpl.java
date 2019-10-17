package me.tmukhortov.zimad.data.repository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.tmukhortov.zimad.data.dto.animal.CatResponse;
import me.tmukhortov.zimad.data.dto.animal.DogResponse;
import me.tmukhortov.zimad.domain.entity.animal.Cat;
import me.tmukhortov.zimad.domain.entity.animal.Dog;
import me.tmukhortov.zimad.domain.repository.AnimalRepository;
import me.tmukhortov.zimad.utility.network.NetworkService;

public class AnimalRepositoryImpl implements AnimalRepository {

    @Override
    public Single<List<Cat>> getCatList() {
        return NetworkService.getInstance().getZimadAPI().catList().subscribeOn(Schedulers.single())
                             .observeOn(AndroidSchedulers.mainThread()).map(response -> {
                    final List<Cat> catList = new ArrayList<>();
                    final List<CatResponse> catResponseList = response.getData();

                    int count = 0;
                    for (CatResponse catResponse : catResponseList) {
                        final String number = String.valueOf(++count);
                        final String url = catResponse.getUrl();
                        final String title = catResponse.getUrl();
                        catList.add(new Cat(number, url, title));
                    }
                    return catList;
                });

    }

    @Override
    public Single<List<Dog>> getDogList() {
        return NetworkService.getInstance().getZimadAPI().dogList().subscribeOn(Schedulers.single())
                             .observeOn(AndroidSchedulers.mainThread()).map(response -> {
                    final List<Dog> dogList = new ArrayList<>();
                    final List<DogResponse> dogResponseList = response.getData();

                    int count = 0;
                    for (DogResponse dogResponse : dogResponseList) {
                        final String number = String.valueOf(++count);
                        final String url = dogResponse.getUrl();
                        final String title = dogResponse.getUrl();
                        dogList.add(new Dog(number, url, title));
                    }
                    return dogList;
                });
    }
}
