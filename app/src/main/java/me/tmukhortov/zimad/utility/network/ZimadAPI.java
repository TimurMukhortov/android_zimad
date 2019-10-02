package me.tmukhortov.zimad.utility.network;

import java.util.List;

import me.tmukhortov.zimad.data.Animal;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ZimadAPI {

    @GET("/xim/api.php?query=cat")
    Call<List<Animal>> catList();

    @GET("/xim/api.php?query=dog")
    Call<List<Animal>> dogList();
}
