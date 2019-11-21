package me.tmukhortov.zimad.presentation.animal.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import com.google.android.material.tabs.TabLayout;
import me.tmukhortov.zimad.R;
import me.tmukhortov.zimad.ZimadApplication;
import me.tmukhortov.zimad.presentation.animal.animal_list.fragment.CatListFragment;
import me.tmukhortov.zimad.presentation.animal.animal_list.fragment.DogListFragment;
import me.tmukhortov.zimad.presentation.base.activity.BaseActivity;

public class MainActivity extends BaseActivity {

    private static final String TAB_STATE = "tab_state";

    private int selectedTab = -1;
    private TabLayout.BaseOnTabSelectedListener bottomBarTabSelectedListener;
    private TabLayout bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomBar = findViewById(R.id.activity_main_tab_layout_action);
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
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
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
