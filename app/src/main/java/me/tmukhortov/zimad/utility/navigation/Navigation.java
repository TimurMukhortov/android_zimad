package me.tmukhortov.zimad.utility.navigation;

import android.app.Activity;

import androidx.fragment.app.Fragment;

public interface Navigation {

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
