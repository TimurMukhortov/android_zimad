package me.tmukhortov.zimad.utility.navigation;

import android.app.Activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public interface Navigation {

    void init(FragmentManager fragmentManager);

    /**
     * Open specific fragment
     *
     * @param fragment
     */
    void navigateTo(Fragment fragment);

    /**
     * Back to previous screen in stack
     */
    void back(Activity baseActivity);

    /**
     * Back to specific fragment
     */
    void backTo();
}
