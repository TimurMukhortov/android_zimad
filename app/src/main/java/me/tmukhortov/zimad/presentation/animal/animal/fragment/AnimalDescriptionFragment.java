package me.tmukhortov.zimad.presentation.animal.animal.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.squareup.picasso.Picasso;
import me.tmukhortov.zimad.R;
import me.tmukhortov.zimad.presentation.animal.animal.entity.AnimalDto;

public class AnimalDescriptionFragment extends Fragment {

    private ImageView avatarView;
    private TextView descriptionView;

    public static AnimalDescriptionFragment newInstance(AnimalDto animalDto) {
        AnimalDescriptionFragment animalDescriptionFragment = new AnimalDescriptionFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(BUNDLE_KEY_ANIMAL_DESCRIPTION, animalDto);
        animalDescriptionFragment.setArguments(bundle);
        return animalDescriptionFragment;
    }

    private static String BUNDLE_KEY_ANIMAL_DESCRIPTION = "bundle_key_animal_description";

    // TODO данные могут не прийти. надо что-то отобразить. возможно какую то ошибку и закрыть
    //  экран..
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_animal_description, container, false);
        avatarView = rootView.findViewById(R.id.fragment_animal_description_avatar);
        descriptionView = rootView.findViewById(R.id.fragment_animal_description_title);
        if (getArguments() != null) {
            AnimalDto animalDto = getArguments().getParcelable(BUNDLE_KEY_ANIMAL_DESCRIPTION);
            if (animalDto != null) {
                // set avatar
                String avatarPath = animalDto.getAvatarPath();
                if (avatarPath != null) {
                    Picasso.get().load(avatarPath).resize(75, 75).centerCrop().into(avatarView);
                }
                // set title
                String description = animalDto.getDescription();
                if (description != null) {
                    descriptionView.setText(description);
                }
            }
        }
        return rootView;
    }
}
