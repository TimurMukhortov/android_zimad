package me.tmukhortov.zimad.presentation.animal.list.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.tabs.TabLayout;
import me.tmukhortov.zimad.R;
import me.tmukhortov.zimad.presentation.animal.list.fragment.CatFragment;
import me.tmukhortov.zimad.presentation.animal.list.fragment.DogFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAB_STATE = "tab_state";

    private int selectedTab = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout actionView = findViewById(R.id.activity_main_tab_layout_action);
        actionView.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0: {
                        selectedTab = 0;
                        openCatFragment();
                        break;
                    }
                    case 1: {
                        selectedTab = 1;
                        openDogFragment();
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        if (savedInstanceState == null) {
            selectedTab = 0;
            openCatFragment();
        } else {
            actionView.getTabAt(savedInstanceState.getInt(TAB_STATE)).select();
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
}
