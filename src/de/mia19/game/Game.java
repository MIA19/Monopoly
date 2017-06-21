package de.mia19.game;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class Game
{

    private static final String NAME = "Monopoly";
    private static Game instance;

    private List<Player> players;
    private Player activePlayer;
    //DEFAULT VALUES

    private long START_MONEY = 400;
    public boolean FREE_PARKING;
    public boolean DOUBLE_MONEY;

    private Thread thread;

    public synchronized void start()
    {
        instance = this;

        thread = new Thread(NAME + "_main");
        thread.start();


        players = new ArrayList<>();
        int playerCount = Integer.parseInt(JOptionPane.showInputDialog("Anzahl"));

        //TODO Player assign color automatically
        for(int i = 0;i < playerCount; i++)
        {
            players.add(new Player(Color.parseString(JOptionPane.showInputDialog("Farbe"))));

            //SETTING GAME SETTINGS
            players.get(i).setMoney(START_MONEY);
        }

        activePlayer = players.get(0);
    }

    public synchronized void stop()
    {
        try
        {
            thread.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
