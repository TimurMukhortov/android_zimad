package me.tmukhortov.zimad.domain.interactor;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import me.tmukhortov.zimad.data.dto.animal.CatResponse;
import me.tmukhortov.zimad.domain.entity.animal.Cat;
import me.tmukhortov.zimad.domain.entity.animal.base.Animal;
import me.tmukhortov.zimad.domain.interactor.base.AnimalUseCase;

public class CatListUseCase extends AnimalUseCase<Animal> {

    @Override
    public Single<List<Animal>> execute() {
        return animalRepository.getCatList().map(response -> {
            final List<Animal> catList = new ArrayList<>();
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
}
