package me.tmukhortov.zimad.presentation.animal.list.fragment.base;

import android.app.ProgressDialog;
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

public abstract class BaseRecyclerFragment extends Fragment {

    private SwipeRefreshLayout swipeRefreshLayoutView;
    private ProgressBar progressBarView;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_base, container, false);
        swipeRefreshLayoutView = rootView.findViewById(R.id.fragment_base_swipe_refresh_layout);
        progressBarView = rootView.findViewById(R.id.fragment_base_recycler_progress);
        recyclerView = rootView.findViewById(R.id.fragment_base_recycler_list);
        swipeRefreshLayoutView.setOnRefreshListener(onRefreshListener());
        setAdapter(rootView, container, recyclerView);
        return rootView;
    }

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
