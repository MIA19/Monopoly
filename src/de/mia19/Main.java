package de.mia19;


import de.mia19.game.Game;
import de.mia19.gui.StartScreen;

public class Main
{

    private static Game game = new Game();

    public static void main(String[] args)
    {
        new StartScreen(game);
    }

}
