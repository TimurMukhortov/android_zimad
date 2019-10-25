package me.tmukhortov.zimad.utility.navigation.navigator;

import android.app.Activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public interface Navigator {

    void init(FragmentManager fragmentManager);

    /**
     * Open specific {@link Fragment}
     *
     * @param fragment
     */
    void navigateTo(Fragment fragment);

    /**
     * Back to previous screen in stack
     */
    void back(Activity baseActivity);

    /**
     * Back to specific {@link Fragment}
     */
    void backTo(Fragment fragment);
}
