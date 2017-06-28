package de.mia19;


import de.mia19.game.Game;
import de.mia19.gui.StartScreen;

import java.util.ArrayList;

public class Main
{

    private static Game game = new Game();

    public static void main(String[] args)
    {
        ArrayList<String> test = new ArrayList<>();
        new StartScreen(game);
    }

}
