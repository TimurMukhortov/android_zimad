package me.tmukhortov.zimad.presentation.animal.list.activity;

import android.content.res.Configuration;
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
                        openCatFragment();
                        break;
                    }
                    case 1: {
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
            openCatFragment();
        }
    }

    // TODO убрать это говно. нужна какая-то обертка или NavigationComponent
    private void openCatFragment() {
        CatFragment catFragment = CatFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, catFragment);
        fragmentTransaction.addToBackStack(CatFragment.TAG);
        fragmentTransaction.commit();
    }

    // TODO убрать это говно. нужна какая-то обертка или NavigationComponent
    private void openDogFragment() {
        DogFragment dogFragment = DogFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, dogFragment);
        fragmentTransaction.addToBackStack(DogFragment.TAG);
        fragmentTransaction.commit();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        String s = "";
    }
}
// TODO найден баг, если включит экран с кошками, перейти на экран с собаками и повернуть экран
//  включается снова экран с кошками.