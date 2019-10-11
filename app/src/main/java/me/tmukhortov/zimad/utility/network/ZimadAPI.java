package me.tmukhortov.zimad.utility.network;

import io.reactivex.Single;
import me.tmukhortov.zimad.data.entity.AnimalDto;
import me.tmukhortov.zimad.data.entity.Response;
import retrofit2.http.GET;

public interface ZimadAPI {

    @GET("/xim/api.php?query=cat")
    Single<Response<AnimalDto>> catList();

    @GET("/xim/api.php?query=dog")
    Single<Response<AnimalDto>> dogList();
}
