package me.tmukhortov.zimad.presentation.animal.list.activity;

import java.util.List;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import me.tmukhortov.zimad.R;
import me.tmukhortov.zimad.data.entity.Animal;
import me.tmukhortov.zimad.presentation.animal.list.viewmodel.AnimalViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnimalViewModel animalViewModel = ViewModelProviders.of(this).get(AnimalViewModel.class);
        animalViewModel.getCatList().observe(this, new Observer<List<Animal>>() {
            @Override
            public void onChanged(List<Animal> animals) {
                String s = "";
            }
        });
    }
}
