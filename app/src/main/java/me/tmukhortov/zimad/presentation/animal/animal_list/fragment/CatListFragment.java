package me.tmukhortov.zimad.presentation.animal.animal_list.fragment;

import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import me.tmukhortov.zimad.presentation.animal.animal_list.adapter.AnimalAdapter;
import me.tmukhortov.zimad.presentation.animal.animal_list.entity.base.Animal;
import me.tmukhortov.zimad.presentation.animal.animal_list.fragment.base.AnimalListFragment;
import me.tmukhortov.zimad.presentation.animal.animal_list.viewmodel.CatListViewModel;
import me.tmukhortov.zimad.presentation.base.viewmodel.BaseViewModel;

public class CatListFragment extends AnimalListFragment {

    private AnimalAdapter adapter;

    public static CatListFragment newInstance() {
        CatListFragment catFragment = new CatListFragment();
        return catFragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {
            showProgressView();
            viewModel = ViewModelProviders.of(getActivity()).get(CatListViewModel.class);
            viewModel.getData().observe(getViewLifecycleOwner(), animalList -> {
                adapter.setItems(animalList);
                hideProgressView();
                hideRefreshView();
            });
        }
    }

    @Override
    public BaseViewModel<List<Animal>> initViewModel() {
        return ViewModelProviders.of(requireActivity()).get(CatListViewModel.class);
    }

    @Override
    public void setAdapter(View rootView, ViewGroup container, RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new AnimalAdapter();
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected SwipeRefreshLayout.OnRefreshListener onRefreshListener() {
        return () -> viewModel.refresh();
    }
}
