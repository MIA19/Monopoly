package de.mia19;


import de.mia19.game.Game;
import de.mia19.gui.StartScreen;
import de.mia19.gui.Theme;

import java.util.ArrayList;

public class Main
{

    private static Game game = new Game();

    public static void main(String[] args)
    {
        game.setTheme(Theme.original);
        ArrayList<String> test = new ArrayList<>();
        new StartScreen(game);
    }

}
