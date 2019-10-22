package me.tmukhortov.zimad.presentation.animal.list.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import me.tmukhortov.zimad.R;
import me.tmukhortov.zimad.ZimadApplication;
import me.tmukhortov.zimad.presentation.animal.item.fragment.AnimalDescriptionFragment;
import me.tmukhortov.zimad.presentation.animal.list.entity.base.AnimalView;

public class AnimalViewHolder extends RecyclerView.ViewHolder {

    private ImageView avatarView;
    private TextView titleView;
    private TextView descriptionView;

    // TODO подумать, возможно вынести в базовый класс какой-то
    public AnimalViewHolder(View itemView) {
        super(itemView);
        avatarView = itemView.findViewById(R.id.fragment_animal_list_avatar);
        titleView = itemView.findViewById(R.id.fragment_animal_list_number);
        descriptionView = itemView.findViewById(R.id.fragment_animal_list_description);
        itemView.setOnClickListener(
                view -> ZimadApplication.INSTANCE.getNavigationHolder().getNavigator().navigateTo(
                        AnimalDescriptionFragment.newInstance()));
    }

    public void bind(AnimalView animal) {
        String avatarPath = animal.getAvatarPath();
        if (avatarPath != null) {
            Picasso.get().load(avatarPath).resize(75, 75).centerCrop().into(avatarView);
        }
        titleView.setText(animal.getNumber());
        descriptionView.setText(animal.getDescription());
    }
}
