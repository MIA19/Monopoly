package de.mia19.game;

/**
 * Spieler Klasse
 */
public class Player
{
    private Color color;
    private long money;
    private int position;
    private boolean inPrison;

    public Player(Color color)
    {
        this.color = color;
    }

    public Color getColor()
    {
        return color;
    }

    public long getMoney()
    {
        return money;
    }

    public void setMoney(long money)
    {
        this.money = money;
    }

    public void addMoney(long money)
    {
        this.money += money;
    }

    public void removeMoney(long money)
    {
        this.money -= money;
    }

    public void setPosition(int position)
    {
        this.position = position;
    }

    public int getPosition()
    {
        return position;
    }

    public void setInPrison(boolean inPrison)
    {
        this.inPrison = inPrison;
    }

    public boolean isInPrison()
    {
        return inPrison;
    }
}
