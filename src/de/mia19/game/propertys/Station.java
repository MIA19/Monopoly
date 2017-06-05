package de.mia19.game.propertys;

/**
 * Created by Invalid on 05.06.2017.
 */
public class Station extends Property
{
    public Station(String name, FieldType type, long price, long rent, int xCoord, int yCoord)
    {
        super(name, type, price, rent, xCoord, yCoord);
    }

    @Override
    public long getRent()
    {
        return super.getRent();
    }
}
