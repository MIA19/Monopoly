package de.mia19;


import de.mia19.game.Game;
import de.mia19.game.Stats;
import de.mia19.gui.GameScreen;
import de.mia19.gui.StartScreen;
import de.mia19.gui.Theme;

public class Main
{

    private static Game game = new Game();

    public static void main(String[] args)
    {
        //new StartScreen(game);
      new GameScreen("spielfeld-beta");
        Stats.increaseStarted();
    }

}
