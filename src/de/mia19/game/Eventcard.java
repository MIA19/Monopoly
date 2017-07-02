package de.mia19.game;

import javax.swing.*;

/**
 * Created by e6_schneider on 14.06.2017.
 */
public class Eventcard
{

    private long money;
    private String event;
    private ImageIcon icon;
    private int position;

    /**
     * @param money long,der dem Geld in dem Event entspricht. bei einer erforderlichen Zahlung ist dieser Wert negativ, bei erhalt von Geld positiv.
     * @param event String eine Umschreibung des Ereignisses.
     */
    public Eventcard(int position, int money, String event)
    {
        this.money = money;
        this.event = event;
        this.icon = new ImageIcon(this.getClass().getResource("images/Karten_png.Karten_png/Ereigniskarte_Field.png"));
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

    public int getPosition() {
        return position;
    }

    public ImageIcon getIcon() {
        return icon;
    }
}
