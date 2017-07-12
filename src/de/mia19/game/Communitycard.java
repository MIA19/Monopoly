package de.mia19.game;

import de.mia19.RessourceLoader;

import javax.swing.*;

/**
 * Created by e6_schneider on 31.05.2017.
 */
public class Communitycard
{
    private long money;
    private String event;
    private ImageIcon icon;
    private int position;

    /**
     +     * @param position die neue Position die der Spieler einnehmen soll.
     +     * @param money Die im Event genannte Summe. Bei einem Abzug ist dieser Wert negativ.
     +     * @param event Die Umschreibung des Ereignisses.
     */
    public Communitycard(int position, long money, String event)
    {
        this.money = money;
        this.event = event;
        this.icon = new ImageIcon(RessourceLoader.getImage("karten/Gemeinschaftskarte_Field.png"));
        this.position = position;
    }

    public long getMoney()
    {
        return money;
    }

    public String getEvent()
    {
        return event;
    }

    public int getPosition()
    {
        return position;
    }

    public ImageIcon getIcon()
    {
        return icon;
    }
}



