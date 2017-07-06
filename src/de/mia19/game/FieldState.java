package de.mia19.game;

/**
 * Created with IntelliJ IDEA 2016.1.3
 * Created by Lucas.Tilsner
 * Date: 15.06.2017
 * Time: 08:15
 */
public enum FieldState
{
    startField(false),
    trainStation(true),
    prison(false),
    goToPrison(false),
    workField(true),
    cardFieldE(false),
    cardFieldG(false),
    taxField(false),
    freeParking(false),
    normalStreetsPurple(true),
    normalStreetsBlue(true),
    normalStreetsPink(true),
    normalStreetsOrange(true),
    normalStreetsRed(true),
    normalStreetsYellow(true),
    normalStreetsGreen(true),
    normalStreetsDarkBlue(true);

    private boolean buyAble;

    FieldState(boolean buyAble)
    {
        this.buyAble = buyAble;
    }

    public boolean isBuyAble()
    {
        return buyAble;
    }
}
