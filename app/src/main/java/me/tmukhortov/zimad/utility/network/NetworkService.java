package me.tmukhortov.zimad.utility.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class NetworkService {

    private static final NetworkService instance = new NetworkService();
    private static final String BASE_URL = "http://kot3.com";
    private final ZimadAPI zimadAPI;

    private NetworkService() {
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson)).build();
        zimadAPI = retrofit.create(ZimadAPI.class);
    }

    public static NetworkService getInstance() {
        return instance;
    }

    public ZimadAPI getZimadAPI() {
        return zimadAPI;
    }
}
