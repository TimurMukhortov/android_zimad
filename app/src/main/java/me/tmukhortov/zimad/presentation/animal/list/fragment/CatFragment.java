package me.tmukhortov.zimad.presentation.animal.list.fragment;

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
import me.tmukhortov.zimad.presentation.animal.list.adapter.AnimalAdapter;
import me.tmukhortov.zimad.presentation.animal.list.entity.base.AnimalView;
import me.tmukhortov.zimad.presentation.animal.list.viewmodel.CatListViewModel;
import me.tmukhortov.zimad.presentation.base.fragment.BaseRecyclerFragment;
import me.tmukhortov.zimad.presentation.base.viewmodel.BaseViewModel;

public class CatFragment extends BaseRecyclerFragment {

    private AnimalAdapter adapter;
    private BaseViewModel<List<AnimalView>> viewModel;

    public static CatFragment newInstance() {
        CatFragment catFragment = new CatFragment();
        return catFragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {
            showProgressView();
            viewModel = ViewModelProviders.of(getActivity()).get(CatListViewModel.class);
            viewModel.getData().observe(this, animalList -> {
                adapter.setItems(animalList);
                hideProgressView();
                hideRefreshView();
            });
        }
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
