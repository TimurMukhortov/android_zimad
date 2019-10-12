package me.tmukhortov.zimad.utility.network;

import io.reactivex.Single;
import me.tmukhortov.zimad.data.entity.animal.base.Animal;
import me.tmukhortov.zimad.data.entity.response.Response;
import retrofit2.http.GET;

public interface ZimadAPI {

    @GET("/xim/api.php?query=cat")
    Single<Response<Animal>> catList();

    @GET("/xim/api.php?query=dog")
    Single<Response<Animal>> dogList();
}
