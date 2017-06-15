package de.mia19.game;

/**
 * Created with IntelliJ IDEA 2016.1.3
 * Created by Lucas.Tilsner
 * Date: 15.06.2017
 * Time: 08:15
 */
public enum FieldState {
    startField (false),
    trainStation (false),
    prison (false),
    goToPrison (false),
    cardField (false),
    taxField (false),
    freeParking (false),
    normalStreets (true);

    private boolean buyAble;

    FieldState (boolean buyAble) {
        this.buyAble = buyAble;
    }

    public boolean isBuyAble () {
        return buyAble;
    }
}
