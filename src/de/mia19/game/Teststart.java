package de.mia19.game;

import javax.swing.*;

/**
 * Created by e6_luczak on 29.06.2017.
 */
public class Teststart
{

    public static void main(String[] args)
    {
        Turn turn = new Turn(new Player(Color.BLUE, "huhu"));

        if(turn.rollButton() == 0)
        {
            System.out.println(turn.rollButton());
        }
    }
}
