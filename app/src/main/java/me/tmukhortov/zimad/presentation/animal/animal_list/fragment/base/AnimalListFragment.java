package me.tmukhortov.zimad.presentation.animal.animal_list.fragment.base;

import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import me.tmukhortov.zimad.R;
import me.tmukhortov.zimad.presentation.animal.animal_list.entity.base.Animal;
import me.tmukhortov.zimad.presentation.base.viewmodel.BaseViewModel;

public abstract class AnimalListFragment extends Fragment {

    protected BaseViewModel<List<Animal>> viewModel;

    private SwipeRefreshLayout swipeRefreshLayoutView;
    private ProgressBar progressBarView;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_animals_list, container, false);
        swipeRefreshLayoutView =
                rootView.findViewById(R.id.fragment_animals_list_swipe_refresh_layout);
        progressBarView = rootView.findViewById(R.id.fragment_animals_list_progress_bar);
        recyclerView = rootView.findViewById(R.id.fragment_animals_list_recycler_list);
        swipeRefreshLayoutView.setOnRefreshListener(onRefreshListener());
        viewModel = initViewModel();
        setAdapter(rootView, container, recyclerView);
        return rootView;
    }

    public abstract BaseViewModel<List<Animal>> initViewModel();

    public abstract void setAdapter(View rootView, ViewGroup container, RecyclerView recyclerView);

    protected void showProgressView() {
        if (progressBarView != null) {
            if (progressBarView.getVisibility() != View.VISIBLE) {
                progressBarView.setVisibility(View.VISIBLE);
            }
        }
    }

    protected void hideProgressView() {
        if (progressBarView != null) {
            if (progressBarView.getVisibility() != View.GONE) {
                progressBarView.setVisibility(View.GONE);
            }
        }
    }

    protected void hideRefreshView() {
        swipeRefreshLayoutView.setRefreshing(false);
    }

    protected abstract SwipeRefreshLayout.OnRefreshListener onRefreshListener();
}
