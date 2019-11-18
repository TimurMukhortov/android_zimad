package me.tmukhortov.zimad.presentation.animal.animal_list.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import me.tmukhortov.zimad.R;
import me.tmukhortov.zimad.ZimadApplication;
import me.tmukhortov.zimad.presentation.animal.animal.entity.AnimalDto;
import me.tmukhortov.zimad.presentation.animal.animal.fragment.AnimalDescriptionFragment;
import me.tmukhortov.zimad.presentation.animal.animal_list.entity.base.Animal;

public class AnimalViewHolder extends RecyclerView.ViewHolder {

    private ImageView avatarView;
    private TextView titleView;
    private TextView descriptionView;

    private Animal animal;

    public AnimalViewHolder(View itemView) {
        super(itemView);
        avatarView = itemView.findViewById(R.id.fragment_animal_list_avatar);
        titleView = itemView.findViewById(R.id.fragment_animal_list_number);
        descriptionView = itemView.findViewById(R.id.fragment_animal_list_description);
        itemView.setOnClickListener(v -> {
            final String avatarPath = animal.getAvatarPath();
            final String number = animal.getNumber();
            final String description = animal.getDescription();
            ZimadApplication.INSTANCE.getNavigationHolder().getNavigator().replace(
                    AnimalDescriptionFragment
                            .newInstance(new AnimalDto(avatarPath, number, description)));
        });
    }

    public void bind(Animal animal) {
        this.animal = animal;
        String avatarPath = animal.getAvatarPath();
        if (avatarPath != null) {
            Picasso.get().load(avatarPath).resize(75, 75).centerCrop().into(avatarView);
        }
        titleView.setText(animal.getNumber());
        descriptionView.setText(animal.getDescription());
    }
}
