package me.tmukhortov.zimad.utility.navigation.navigator;

import java.util.LinkedList;
import java.util.Queue;

import android.app.Activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import me.tmukhortov.zimad.R;
import me.tmukhortov.zimad.utility.navigation.Screen.Screen;
import me.tmukhortov.zimad.utility.navigation.command.Command;
import me.tmukhortov.zimad.utility.navigation.command.Forward;
import me.tmukhortov.zimad.utility.navigation.command.Replace;

/**
 * Helper class to ease the navigation between screens.
 */
public class NavigatorImpl implements Navigator {

    private FragmentManager fragmentManager;
    private NavigationListener navigationListener;
    private Queue<Command> commandQueue = new LinkedList<>();

    /**
     * Listener interface for navigation events.
     */
    public interface NavigationListener {

        /**
         * Callback on backstack changed.
         */
        void onBackStackChanged();
    }

    public NavigationListener getNavigationListener() {
        return navigationListener;
    }

    public void setNavigationListener(NavigationListener navigationListener) {
        this.navigationListener = navigationListener;
    }

    /**
     * Initialize the {@link NavigatorImpl} with a {@link FragmentManager}, which will be used
     * at the
     * fragment transactions.
     *
     * @param fragmentManager
     */
    @Override
    public void init(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
        fragmentManager.addOnBackStackChangedListener(() -> {
            if (navigationListener != null) {
                navigationListener.onBackStackChanged();
            }
        });
    }

    /**
     * Displays the next fragment
     *
     * @param fragment
     */
    @Override
    public void navigateTo(Fragment fragment) {
        if (fragmentManager != null) {
            Screen screen = new Screen();
            Command command = new Forward(screen);
            commandQueue.add(command);
            fragmentManager.beginTransaction().add(R.id.fragment_container, fragment)
                           .addToBackStack(fragment.toString()).commit();
        }
    }

    /**
     * Navigates back by popping teh back stack. If there is no more items left we finish the current activity.
     *
     * @param baseActivity
     */
    @Override
    public void back(Activity baseActivity) {
        if (fragmentManager != null) {
            if (fragmentManager.getBackStackEntryCount() == 0) {
                baseActivity.finish();
            } else {
                fragmentManager.popBackStackImmediate();
            }
        }
    }

    /**
     * Popping in back stack current display {@link Fragment} and replace to specific.
     *
     * @param fragment
     */
    @Override
    public void replace(Fragment fragment) {
        if (fragmentManager != null) {
            Screen screen = new Screen();
            Command command = new Replace(screen);
            commandQueue.add(command);
            fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
                           .addToBackStack(fragment.toString()).commit();
        }
    }
}
