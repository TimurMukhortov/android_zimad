package me.tmukhortov.zimad.presentation.animal.list.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import me.tmukhortov.zimad.R;
import me.tmukhortov.zimad.presentation.animal.list.adapter.AnimalAdapter;
import me.tmukhortov.zimad.presentation.animal.list.fragment.base.BaseFragment;
import me.tmukhortov.zimad.presentation.animal.list.viewmodel.AnimalViewModel;

public class CatFragment extends BaseFragment {

    private AnimalAdapter adapter;

    public static CatFragment newInstance() {
        CatFragment catFragment = new CatFragment();
        return catFragment;
    }

    @Override
    protected SwipeRefreshLayout.OnRefreshListener onRefreshListener() {
        return this::loadData;
    }

    @Override
    public void loadChildView(View rootView, ViewGroup container) {
        setRetainInstance(true);
        if (container != null) {
            container.removeAllViews();
        }
        ViewStub stubView = rootView.findViewById(R.id.fragment_base_child_fragment);
        stubView.setLayoutResource(R.layout.fragment_cat_list);
        stubView.inflate();
        loadData();
        isRefreshing = true;
        final RecyclerView recyclerView = rootView.findViewById(R.id.fragment_cat_list_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new AnimalAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void loadData() {
        if (getActivity() != null) {
            showProgressView();
            AnimalViewModel animalViewModel =
                    ViewModelProviders.of(getActivity()).get(AnimalViewModel.class);
            animalViewModel.getCatList().observe(this, animalList -> {
                adapter.setItems(animalList);
                hideProgressView();
                hideRefreshView();
            });
        }
    }
}
