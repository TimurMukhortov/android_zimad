package me.tmukhortov.zimad.presentation.animal.animal_list.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.tabs.TabLayout;
import me.tmukhortov.zimad.R;
import me.tmukhortov.zimad.ZimadApplication;

public class TabFragment extends Fragment {

    private static final String TAB_STATE = "tab_state";

    private int selectedTab = -1;
    private TabLayout.BaseOnTabSelectedListener bottomBarTabSelectedListener;
    private TabLayout bottomBar;

    public static TabFragment newInstance(){
        TabFragment tabFragment = new TabFragment();
        return tabFragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_animals_tabs, container, false);
        bottomBar = rootView.findViewById(R.id.activity_main_tab_layout_action);
        bottomBarTabSelectedListener = new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0: {
                        selectedTab = 0;
                        ZimadApplication.INSTANCE.getNavigationHolder().getNavigator()
                                                 .replace(CatListFragment.newInstance());
                        break;
                    }
                    case 1: {
                        selectedTab = 1;
                        ZimadApplication.INSTANCE.getNavigationHolder().getNavigator()
                                                 .replace(DogListFragment.newInstance());
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        };
        bottomBar.addOnTabSelectedListener(bottomBarTabSelectedListener);
        if (savedInstanceState == null) {
            selectedTab = 0;
            ZimadApplication.INSTANCE.getNavigationHolder().getNavigator()
                                     .navigateTo(CatListFragment.newInstance());
        } else {
            int positionTab = savedInstanceState.getInt(TAB_STATE);
            highlightBottomBarMenu(positionTab);
        }
        return rootView;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(TAB_STATE, selectedTab);
    }

    private void highlightBottomBarMenu(int position) {
        bottomBar.removeOnTabSelectedListener(bottomBarTabSelectedListener);
        TabLayout.Tab tab = bottomBar.getTabAt(position);
        if (tab != null) {
            tab.select();
        }
        bottomBar.addOnTabSelectedListener(bottomBarTabSelectedListener);
    }
}
