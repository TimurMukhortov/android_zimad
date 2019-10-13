package me.tmukhortov.zimad.domain.interactor;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import me.tmukhortov.zimad.data.dto.animal.DogResponse;
import me.tmukhortov.zimad.domain.entity.animal.Dog;
import me.tmukhortov.zimad.domain.entity.animal.base.Animal;
import me.tmukhortov.zimad.domain.interactor.base.AnimalUseCase;

public class DogListUseCase extends AnimalUseCase<Animal> {

    @Override
    public Single<List<Animal>> execute() {
        return animalRepository.getDogList().map(response -> {
            final List<Animal> dogList = new ArrayList<>();
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
