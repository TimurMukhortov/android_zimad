package me.tmukhortov.zimad.presentation.animal.list.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import me.tmukhortov.zimad.R;
import me.tmukhortov.zimad.presentation.animal.list.viewmodel.AnimalViewModel;

public class CatFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cat_list, container, false);
        Toast.makeText(getContext(), "Cat list!", Toast.LENGTH_SHORT).show();
        if (getActivity() != null) {
            AnimalViewModel animalViewModel =
                    ViewModelProviders.of(getActivity()).get(AnimalViewModel.class);
            animalViewModel.getCatList().observe(this, animals -> {
                String s = "";
            });
        }
        return view;
    }
}
