package me.tmukhortov.zimad.utility.navigation.holder;

import me.tmukhortov.zimad.utility.navigation.navigator.Navigator;

public interface NavigatorHolder {

    void setNavigator(Navigator navigator);

    Navigator getNavigator();

    void removeNavigator();
}
