package me.tmukhortov.zimad.presentation.base.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import me.tmukhortov.zimad.ZimadApplication;
import me.tmukhortov.zimad.utility.navigation.navigator.Navigator;
import me.tmukhortov.zimad.utility.navigation.navigator.NavigatorImpl;

/**
 * Base activity for all the Activities, it provides some common operation for all of the sub-activities.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initNavigationHolder();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initNavigationHolder();
    }

    @Override
    protected void onPause() {
        super.onPause();
        ZimadApplication.INSTANCE.getNavigationHolder().unbind();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ZimadApplication.INSTANCE.getNavigationHolder().getNavigator().back(this);
    }

    private void initNavigationHolder() {
        if (ZimadApplication.INSTANCE.getNavigationHolder().getNavigator() == null) {
            Navigator navigator = new NavigatorImpl();
            navigator.init(getSupportFragmentManager());
            ZimadApplication.INSTANCE.getNavigationHolder().bind(navigator);
        }
    }
}
