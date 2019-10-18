package me.tmukhortov.zimad.presentation.animal.list.fragment;

import java.util.List;

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
import me.tmukhortov.zimad.presentation.animal.list.adapter.AnimalAdapter;
import me.tmukhortov.zimad.presentation.animal.list.entity.base.AnimalView;
import me.tmukhortov.zimad.presentation.animal.list.viewmodel.DogListViewModel;
import me.tmukhortov.zimad.presentation.base.viewmodel.BaseViewModel;

public class DogFragment extends Fragment {

    private AnimalAdapter adapter;
    private BaseViewModel<List<AnimalView>> viewModel;

    public static DogFragment newInstance() {
        DogFragment dogFragment = new DogFragment();
        return dogFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_dog_list, container, false);

        if (getActivity() != null) {
            viewModel = ViewModelProviders.of(getActivity()).get(DogListViewModel.class);
            viewModel.getData().observe(this, animalList -> adapter.setItems(animalList));
        }

        final RecyclerView recyclerView = rootView.findViewById(R.id.fragment_dog_list_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new AnimalAdapter();
        recyclerView.setAdapter(adapter);
        return rootView;
    }
}
