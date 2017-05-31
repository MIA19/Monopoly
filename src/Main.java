import game.Game;

import javax.swing.*;

public class Main
{
    private static Game game = new Game();

    public static void main(String[] args)
    {
        new Game().start();

        game.frame = new JFrame(Game.NAME);

        game.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.frame.pack();

        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);
    }

}
