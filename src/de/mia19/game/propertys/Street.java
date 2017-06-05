package de.mia19.game.propertys;

import de.mia19.game.Player;

public class Street extends Property
{
    private int houseCounter;
    private final long housePrice;

    public Street(String name, long price, long rent, int xCoord, int yCoord, long housePrice)
    {
        super(name, FieldType.STREET, price, rent, xCoord, yCoord);
        this.housePrice = housePrice;
        this.houseCounter = 0;
    }

    public void buyHouse(Player player)
    {
        if (super.isAlreadyBought())
        {
            if (player.getMoney() >= housePrice && houseCounter < 5)
            {
                houseCounter += 1;
            }
        }
    }
}
