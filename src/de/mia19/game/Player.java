package de.mia19.game;

/**
 * Spieler Klasse
 */
public class Player
{
    private Color color;
    private long money;
    private int position;
    private boolean inJail;

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

    public void setInJail(boolean inJail)
    {
        this.inJail = inJail;
    }

    public boolean isInJail()
    {
        return inJail;
    }
}
