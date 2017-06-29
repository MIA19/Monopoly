package de.mia19.game;

/**
 * Created by e6_luczak on 29.06.2017.
 */
public class Teststart
{

    public static void main(String[] args)
    {
        Turn turn = new Turn(new Player(Color.BLUE));

        turn.rollButton();
    }
}
