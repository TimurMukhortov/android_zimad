package me.tmukhortov.zimad.presentation.animal.list.viewholder;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import me.tmukhortov.zimad.R;
import me.tmukhortov.zimad.presentation.animal.list.entity.Animal;

public class AnimalViewHolder extends RecyclerView.ViewHolder {

    private ImageView avatarView;
    private TextView titleView;
    private TextView descriptionView;

    // TODO подумать, возможно вынести в базовый класс какой-то
    public AnimalViewHolder(View itemView) {
        super(itemView);
        avatarView = itemView.findViewById(R.id.fragment_animal_list_avatar);
        titleView = itemView.findViewById(R.id.fragment_animal_list_title);
        descriptionView = itemView.findViewById(R.id.fragment_animal_list_description);
    }

    public void bind(Animal animal) {
        String avatarPath = animal.getAvatarPath();
        if (avatarPath != null) {
            Picasso.get().load(avatarPath).resize(75, 75).centerCrop().into(avatarView);
        }
        // TODO вот эту хрень передалать и отображать индекс в адаптере + 1
        titleView.setText(animal.getTitle());
        descriptionView.setText(animal.getTitle());
    }
}
