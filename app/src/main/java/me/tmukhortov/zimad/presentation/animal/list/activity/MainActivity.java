package me.tmukhortov.zimad.presentation.animal.list.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import me.tmukhortov.zimad.R;
import me.tmukhortov.zimad.data.response.Animal;
import me.tmukhortov.zimad.data.response.Response;
import me.tmukhortov.zimad.utility.network.NetworkService;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";
    private final ArrayList<Animal> animalList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NetworkService.getInstance().getZimadAPI().catList().subscribeOn(Schedulers.single())
                      .observeOn(AndroidSchedulers.mainThread())
                      .subscribe(new SingleObserver<Response<Animal>>() {
                          @Override
                          public void onSubscribe(Disposable d) {
                          }

                          @Override
                          public void onSuccess(Response<Animal> response) {
                              animalList.addAll(response.getData());
                              printList(animalList);
                          }

                          @Override
                          public void onError(Throwable e) {
                              e.printStackTrace();
                          }
                      });

    }

    private void printList(List<Animal> itemList) {
        for (Animal item : itemList) {
            Log.d(TAG, "Url: " + item.getUrl() + "," + "Title: " + item.getTitle() + "\n");
        }
    }
}
