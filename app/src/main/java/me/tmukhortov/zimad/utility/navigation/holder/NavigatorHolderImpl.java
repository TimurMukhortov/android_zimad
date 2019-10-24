package me.tmukhortov.zimad.utility.navigation.holder;

import me.tmukhortov.zimad.utility.navigation.navigator.Navigator;

public class NavigatorHolderImpl implements NavigatorHolder {

    private NavigatorHolder navigatorHolder;

    private Navigator navigation;

    @Override
    public Navigator getNavigator() {
        return navigation;
    }

    @Override
    public void bind(Navigator navigation) {
        this.navigation = navigation;
    }

    @Override
    public void unbind() {
        this.navigation = null;
    }
}
