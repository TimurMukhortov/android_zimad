package me.tmukhortov.zimad.utility.navigation;

import androidx.fragment.app.Fragment;

public interface Navigation {

    /**
     *
     * Open specific fragment
     * @param fragment
     */
    void navigateTo(Fragment fragment);

    /**
     * Back to previous screen in stack
     */
    void back();

    /**
     * Back to specific fragment
     */
    void backTo();
}
