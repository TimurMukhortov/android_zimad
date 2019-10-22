package me.tmukhortov.zimad.utility.navigation.holder;

import me.tmukhortov.zimad.utility.navigation.navigator.Navigator;

public class NavigatorHolderImpl implements NavigatorHolder {

    private NavigatorHolder navigatorHolder;

    private Navigator navigation;

    @Override
    public void setNavigator(Navigator navigation) {
        this.navigation = navigation;
    }

    @Override
    public Navigator getNavigator() {
        return navigation;
    }

    @Override
    public void removeNavigator() {
        this.navigation = null;
    }
}
