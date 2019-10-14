package me.tmukhortov.zimad.presentation.animal.list.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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

    //    @Nullable
    //    @Override
    //    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
    //                             @Nullable Bundle savedInstanceState) {
    //        final View rootView = inflater.inflate(R.layout.fragment_cat_list, container, false);
    //
    //        if (getActivity() != null) {
    //            AnimalViewModel animalViewModel =
    //                    ViewModelProviders.of(getActivity()).get(AnimalViewModel.class);
    //            animalViewModel.getCatList().observe(this, animalList -> adapter.setItems(animalList));
    //        }
    //
    //        final RecyclerView recyclerView = rootView.findViewById(R.id.fragment_cat_list_recycler);
    //        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    //        adapter = new AnimalAdapter();
    //        recyclerView.setAdapter(adapter);
    //        return rootView;
    //    }

    @Override
    public void loadChildView(View rootView, ViewGroup container) {
        setRetainInstance(true);
        if (container != null) {
            container.removeAllViews();
        }
        showProgressView();
        ViewStub stubView = rootView.findViewById(R.id.fragment_base_child_fragment);
        stubView.setLayoutResource(R.layout.fragment_cat_list);
        stubView.inflate();
        if (getActivity() != null) {
            AnimalViewModel animalViewModel =
                    ViewModelProviders.of(getActivity()).get(AnimalViewModel.class);
            animalViewModel.getCatList().observe(this, animalList -> {
                adapter.setItems(animalList);
                hideProgressView();
            });
        }

        final RecyclerView recyclerView = rootView.findViewById(R.id.fragment_cat_list_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new AnimalAdapter();
        recyclerView.setAdapter(adapter);
    }
}
