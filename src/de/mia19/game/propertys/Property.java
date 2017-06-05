package de.mia19.game.propertys;

import de.mia19.game.Field;
import de.mia19.game.Player;

public class Property extends Field
{
    private final String name;
    private Player owner;

    private final long price;
    private long rent;

    private final FieldType type;

    public Property(String name, FieldType type, long price, long rent, int xCoord, int yCoord)
    {
        super(xCoord, yCoord);
        this.name = name;
        this.type = type;

        this.owner = null;

        this.price = price;
        this.rent = rent;
    }

    public boolean isAlreadyBought()
    {
        return owner != null;
    }

    public long getRent()
    {
        return rent;
    }

    public Player getOwner()
    {
        return owner;
    }

    public long getPrice()
    {
        return price;
    }

    public FieldType getType()
    {
        return type;
    }

    public enum FieldType
    {
        STREET,
        PLANT,
        STATION
    }
}
