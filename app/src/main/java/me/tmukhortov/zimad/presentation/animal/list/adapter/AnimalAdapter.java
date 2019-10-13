package me.tmukhortov.zimad.presentation.animal.list.adapter;

import java.util.ArrayList;
import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import me.tmukhortov.zimad.R;
import me.tmukhortov.zimad.presentation.animal.list.entity.base.AnimalView;
import me.tmukhortov.zimad.presentation.animal.list.viewholder.AnimalViewHolder;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalViewHolder> {

    private List<AnimalView> animalList = new ArrayList<>();

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                                  .inflate(R.layout.item_fragment_animal_list, parent, false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        holder.bind(animalList.get(position));
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    public void setItems(List<AnimalView> itemList) {
        animalList = itemList;
        notifyDataSetChanged();
    }

    public void clearItems() {
        animalList.clear();
        notifyDataSetChanged();
    }
}
