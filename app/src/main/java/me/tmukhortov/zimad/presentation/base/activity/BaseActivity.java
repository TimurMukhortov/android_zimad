package me.tmukhortov.zimad.presentation.base.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import me.tmukhortov.zimad.utility.navigation.Navigation;
import me.tmukhortov.zimad.utility.navigation.NavigationManager;

/**
 * Base activity for all the Activities, it provides some common operation for all of the sub-activities.
 */
public class BaseActivity extends AppCompatActivity {

    protected Navigation navigationManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navigationManager = new NavigationManager();
        navigationManager.init(getSupportFragmentManager());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        navigationManager.back(this);
    }
}
