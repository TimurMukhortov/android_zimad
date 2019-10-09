package me.tmukhortov.zimad.presentation.animal.list.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import me.tmukhortov.zimad.presentation.animal.list.viewmodel.AnimalViewModel;

public class CatFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActivity() != null) {
            AnimalViewModel animalViewModel =
                    ViewModelProviders.of(getActivity()).get(AnimalViewModel.class);
            animalViewModel.getCatList().observe(this, animals -> {
                String s = "";
            });
        }
    }
}
