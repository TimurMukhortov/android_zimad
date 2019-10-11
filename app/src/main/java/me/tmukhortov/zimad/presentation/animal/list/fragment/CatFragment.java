package me.tmukhortov.zimad.presentation.animal.list.fragment;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import me.tmukhortov.zimad.R;
import me.tmukhortov.zimad.data.entity.AnimalDto;
import me.tmukhortov.zimad.presentation.animal.list.adapter.AnimalAdapter;
import me.tmukhortov.zimad.presentation.animal.list.entity.Animal;
import me.tmukhortov.zimad.presentation.animal.list.viewmodel.AnimalViewModel;

public class CatFragment extends Fragment {

    public static final String TAG = CatFragment.class.getName();

    private RecyclerView recyclerView;
    private AnimalAdapter adapter;

    public static CatFragment newInstance() {
        CatFragment catFragment = new CatFragment();
        return catFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cat_list, container, false);
        //        Toast.makeText(getContext(), "Cat list!", Toast.LENGTH_SHORT).show();

        if (getActivity() != null) {
            AnimalViewModel animalViewModel =
                    ViewModelProviders.of(getActivity()).get(AnimalViewModel.class);
            animalViewModel.getCatList().observe(this, animalDtoList -> {
                // TODO переделать по другому
                ArrayList<Animal> animalList = new ArrayList<>();
                for (AnimalDto animalDto : animalDtoList) {
                    String avatarPath = animalDto.getUrl();
                    String title = animalDto.getTitle();
                    animalList.add(new Animal(avatarPath, title));
                }
                adapter.setItems(animalList);
            });
        }

        recyclerView = rootView.findViewById(R.id.fragment_cat_list_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new AnimalAdapter();
        recyclerView.setAdapter(adapter);
        return rootView;
    }
}
