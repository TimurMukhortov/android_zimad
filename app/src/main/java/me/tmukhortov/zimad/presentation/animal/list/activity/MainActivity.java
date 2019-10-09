package me.tmukhortov.zimad.presentation.animal.list.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import com.google.android.material.tabs.TabLayout;
import me.tmukhortov.zimad.R;
import me.tmukhortov.zimad.presentation.animal.list.viewmodel.AnimalViewModel;

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
                        Toast.makeText(getBaseContext(), "Cat list!", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 1: {
                        Toast.makeText(getBaseContext(), "Dog list!", Toast.LENGTH_SHORT).show();
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
        AnimalViewModel animalViewModel = ViewModelProviders.of(this).get(AnimalViewModel.class);
    }
}
