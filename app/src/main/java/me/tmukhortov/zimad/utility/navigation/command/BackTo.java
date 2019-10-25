package me.tmukhortov.zimad.utility.navigation.command;

import me.tmukhortov.zimad.utility.navigation.Screen.Screen;

//TODO возможно он не нужен, так как во всех случаях, в тек. задачи мы переходим на экран назад и
// перехода на конкретный экран у нас нет.
@Deprecated
public class BackTo implements Command {

    final private Screen screen;

    /**
     * Creates a {@link Forward} navigation command
     *
     * @param screen
     */
    public BackTo(final Screen screen) {
        this.screen = screen;
    }

    public Screen getScreen() {
        return screen;
    }
}
