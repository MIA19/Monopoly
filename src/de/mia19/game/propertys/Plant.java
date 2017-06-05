package de.mia19.game.propertys;

public class Plant extends Property
{
    public Plant(String name, long price, int xCoord, int yCoord)
    {
        super(name, FieldType.PLANT, price, -1, xCoord, yCoord);
    }

    @Override
    public long getRent()
    {
        return super.getRent();
    }
}
