package me.tmukhortov.zimad;

import android.app.Application;

import me.tmukhortov.zimad.utility.navigation.holder.NavigatorHolder;
import me.tmukhortov.zimad.utility.navigation.holder.NavigatorHolderImpl;

public class ZimadApplication extends Application {
    public static ZimadApplication INSTANCE;

    private NavigatorHolder navigatorHolder;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        navigatorHolder = new NavigatorHolderImpl();
    }

    public NavigatorHolder getNavigationHolder() {
        return navigatorHolder;
    }
}
