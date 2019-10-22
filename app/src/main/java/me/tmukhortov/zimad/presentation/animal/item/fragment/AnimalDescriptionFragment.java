package me.tmukhortov.zimad.presentation.animal.item.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import me.tmukhortov.zimad.R;

public class AnimalDescriptionFragment extends Fragment {

    public static AnimalDescriptionFragment newInstance() {
        AnimalDescriptionFragment animalDescriptionFragment = new AnimalDescriptionFragment();
        return animalDescriptionFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_animal_description, container, false);
        // TODO get data from dog/cat screen and set to view
        return rootView;
    }
}
