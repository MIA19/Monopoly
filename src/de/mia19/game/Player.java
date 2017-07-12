package de.mia19.game;

/**
 * Spieler Klasse
 */
public class Player
{
    private static String name;
    private ColorPlayer colorPlayer;
    private long money;
    private int position;
    private boolean inJail;

    public Player(ColorPlayer colorPlayer, String name)
    {
        this.colorPlayer = colorPlayer;
        this.position = 0;
        this.name = name;
    }

    public static String getName() {
        return name;
    }

    public ColorPlayer getColorPlayer()
    {
        return colorPlayer;
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
     //   this.position = 10;
    }

    public boolean isInJail()
    {
        return inJail;
    }

    public void move(int fields)
    {
        //TODO NEU ANFANG ÜBER LOS
        this.position += fields;
    }

    public void pay(Player to, long amount)
    {
        if ((money - amount) < 0)
        {
            to.addMoney(money);
            removeMoney(amount);
            //TODO LOST
        } else
        {
            to.addMoney(amount);
            removeMoney(amount);
        }
    }

    public int getCountOfOwnedColorStreets(FieldState fieldState)
    {
        int i = 0;
        for(Field field : Game.getInstance().getOwnedFieldsByPlayer(this))
        {
            if(field.getFieldState().equals(fieldState))
                i++;
        }
        return i;
    }

    public boolean hasAllStreetsOfColor(FieldState fieldState)
    {
        return getCountOfOwnedColorStreets(fieldState) == Game.getInstance().getCountOfMaxStreetColor(fieldState);
    }

}
