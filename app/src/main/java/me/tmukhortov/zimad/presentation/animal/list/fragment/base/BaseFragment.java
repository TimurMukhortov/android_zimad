package me.tmukhortov.zimad.presentation.animal.list.fragment.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import me.tmukhortov.zimad.R;

public abstract class BaseFragment extends Fragment {

    private SwipeRefreshLayout swipeRefreshLayoutView;
    private ProgressBar progressBarView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_base, container, false);
        swipeRefreshLayoutView = rootView.findViewById(R.id.fragment_base_swipe_refresh_layout);
        progressBarView = rootView.findViewById(R.id.fragment_base_progress);
        swipeRefreshLayoutView.setOnRefreshListener(onRefreshListener());
        loadChildView(rootView, container);
        return rootView;
    }

    public abstract void loadChildView(View rootView, ViewGroup container);

    protected void showProgressView() {
        progressBarView.setVisibility(View.VISIBLE);
    }

    protected void hideProgressView() {
        progressBarView.setVisibility(View.GONE);
    }

    protected void hideRefreshView() {
        swipeRefreshLayoutView.setRefreshing(false);
    }

    protected abstract SwipeRefreshLayout.OnRefreshListener onRefreshListener();
}
