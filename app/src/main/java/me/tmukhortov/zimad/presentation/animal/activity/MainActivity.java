package me.tmukhortov.zimad.presentation.animal.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.tabs.TabLayout;
import me.tmukhortov.zimad.R;
import me.tmukhortov.zimad.presentation.animal.list.fragment.CatFragment;
import me.tmukhortov.zimad.presentation.animal.list.fragment.DogFragment;
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
                        //                        openCatFragment();
                        navigationManager.navigateTo(CatFragment.newInstance());
                        break;
                    }
                    case 1: {
                        selectedTab = 1;
                        //                                                openDogFragment();
                        navigationManager.navigateTo(DogFragment.newInstance());
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
            openCatFragment();
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

    // TODO убрать это говно. нужна какая-то обертка или NavigationComponent
    private void openCatFragment() {
        CatFragment catFragment = CatFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, catFragment);
        fragmentTransaction.commit();
    }

    // TODO убрать это говно. нужна какая-то обертка или NavigationComponent
    private void openDogFragment() {
        DogFragment dogFragment = DogFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, dogFragment);
        fragmentTransaction.commit();
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
