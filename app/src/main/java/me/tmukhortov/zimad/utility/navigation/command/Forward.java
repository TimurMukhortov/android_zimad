package me.tmukhortov.zimad.utility.navigation.command;

import me.tmukhortov.zimad.utility.navigation.Screen.Screen;

/**
 * Open new screen.
 */
public class Forward implements Command {

    final private Screen screen;

    /**
     * Creates a {@link Forward} navigation command
     *
     * @param screen
     */
    public Forward(final Screen screen) {
        this.screen = screen;
    }

    public Screen getScreen() {
        return screen;
    }
}
