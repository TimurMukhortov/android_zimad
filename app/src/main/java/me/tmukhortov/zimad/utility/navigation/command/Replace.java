package me.tmukhortov.zimad.utility.navigation.command;

import me.tmukhortov.zimad.utility.navigation.Screen.Screen;

public class Replace implements Command {

    final private Screen screen;

    /**
     * Creates a {@link Replace} navigation command
     *
     * @param screen
     */
    public Replace(final Screen screen) {
        this.screen = screen;
    }

    public Screen getScreen() {
        return screen;
    }
}
