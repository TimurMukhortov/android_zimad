package me.tmukhortov.zimad.utility.navigation;

import android.app.Activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import me.tmukhortov.zimad.R;

/**
 * Helper class to ease the navigation between screens.
 */
public class NavigationManager implements Navigation {

    private FragmentManager fragmentManager;
    private NavigationListener navigationListener;

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
     * Initialize the {@link NavigationManager} with a {@link FragmentManager}, which will be used
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
            fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
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

    @Override
    public void backTo() {
        //TODO latter add back to specific screen..
    }

    /**
     * Pops all the queued fragments
     */
    private void popEveryFragment() {
        if (fragmentManager != null) {
            int backStackCount = fragmentManager.getBackStackEntryCount();
            for (int position = 0; position < backStackCount; position++) {
                int backStackId = fragmentManager.getBackStackEntryAt(position).getId();
                fragmentManager.popBackStack(backStackId, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }
        }
    }
}
