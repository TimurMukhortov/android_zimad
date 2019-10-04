package me.tmukhortov.zimad.utility.network;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import me.tmukhortov.zimad.data.entity.Animal;
import me.tmukhortov.zimad.data.entity.Response;
import retrofit2.http.GET;

public interface ZimadAPI {

    @GET("/xim/api.php?query=cat")
    Single<Response<Animal>> catList();

    @GET("/xim/api.php?query=dog")
    Observable<List<Animal>> dogList();
}
