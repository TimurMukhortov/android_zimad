package me.tmukhortov.zimad.domain.repository;

import io.reactivex.Single;
import me.tmukhortov.zimad.data.entity.animal.base.Animal;
import me.tmukhortov.zimad.data.entity.response.Response;

// TODO перенести интерфейсы в места работы с ними, а не вместа хранения их реализации.
//  Работа с репозиторием происходит через интерфейс. В том месте где мы будем работать с
//  интерфейсом нас не волнует какая у него реализация.
public interface AnimalRepository {

    Single<Response<Animal>> getCatList();

    Single<Response<Animal>> getDogList();
}
