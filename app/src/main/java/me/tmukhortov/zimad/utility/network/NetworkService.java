package me.tmukhortov.zimad.utility.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static NetworkService mInstance;
    private static final String BASE_URL = "http://kot3.com/xim/";
    private Retrofit mRetrofit;

    private NetworkService() {
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson)).build();

        ZimadAPI zimadAPI = retrofit.create(ZimadAPI.class);
    }

    public static NetworkService getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkService();
        }
        return mInstance;
    }
}
