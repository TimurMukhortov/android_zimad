package me.tmukhortov.zimad.data.repository;

import io.reactivex.Single;
import me.tmukhortov.zimad.data.entity.AnimalDto;
import me.tmukhortov.zimad.data.entity.Response;

// TODO перенести интерфейсы в места работы с ними, а не вместа хранения их реализации.
//  Работа с репозиторием происходит через интерфейс. В том месте где мы будем работать с
//  интерфейсом нас не волнует какая у него реализация.
public interface AnimalRepository {

    Single<Response<AnimalDto>> getCatList();

    Single<Response<AnimalDto>> getDogList();
}
