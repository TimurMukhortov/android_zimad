package me.tmukhortov.zimad.utility.navigation.holder;

import androidx.appcompat.app.AppCompatActivity;
import me.tmukhortov.zimad.utility.navigation.navigator.Navigator;

public interface NavigatorHolder {

    /**
     * Get implementation {@link Navigator} from {@link NavigatorHolder}
     *
     * @return {@link Navigator}
     */
    Navigator getNavigator();

    /**
     * Associates a {@link Navigator} implementation with a view
     *
     * @param navigator
     */
    void bind(Navigator navigator);

    /**
     * Clear the bind between a {@link AppCompatActivity} and {@link Navigator}
     */
    void unbind();
}
