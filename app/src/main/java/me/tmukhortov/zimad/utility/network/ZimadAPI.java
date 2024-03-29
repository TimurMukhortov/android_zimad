package me.tmukhortov.zimad.utility.network;

import io.reactivex.Single;
import me.tmukhortov.zimad.data.dto.animal.CatResponse;
import me.tmukhortov.zimad.data.dto.animal.DogResponse;
import me.tmukhortov.zimad.data.dto.response.Response;
import retrofit2.http.GET;

public interface ZimadAPI {

    @GET("/xim/api.php?query=cat")
    Single<Response<CatResponse>> catList();

    @GET("/xim/api.php?query=dog")
    Single<Response<DogResponse>> dogList();
}
