package de.mia19.game;


import javax.swing.*;

public class Field extends JButton
{
    private static String name;
    private static int fieldCount;
    private int fieldNumber; //Nummer des Feldes
    private FieldState fieldState;
    private int xCoord;
    private int yCoord;

    private int price;
    private int costPerHouse;
    private int withHouses[] = new int[5];

    public Field(String name, int xCoord, int yCoord, FieldState fieldState, int fieldPrice, int houseCost, int withOneHouse, int withTwoHouses, int withThreeHouses, int withFourHouses, int withVilla)
    {
        this.name = name;
        this.fieldNumber = Field.fieldCount + 1;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.fieldState = fieldState;
        if(fieldState.isBuyAble ()){
            this.price = fieldPrice;
            this.costPerHouse = houseCost;
            this.withHouses[0] = withOneHouse;
            this.withHouses[1] = withTwoHouses;
            this.withHouses[2] = withThreeHouses;
            this.withHouses[3] = withFourHouses;
            this.withHouses[4] = withVilla;
        }
    }

    public Field (String name, int xCoord, int yCoord, FieldState fieldState) {
        this.name = name;
        this.fieldNumber = Field.fieldCount + 1;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    /*Constructor ohne Kaufpreis
    public Field(int fieldNumber, String name) {
        this.fieldNumber = fieldNumber;
        this.name = name;
        this.buyable = false;
        this.alreadyBought = false;
    }

    //Constructor mit Kaufpreis
    public Field(int fieldNumber, String name, int preis, int hausKosten, int xKoord, int yKoord) {
        this.fieldNumber = fieldNumber;
        this.name = name;
        this.fieldPrice = preis;
        this.buyable = true;
        this.alreadyBought = false;
        this.counterHouse = 0;
        this.housePrice = hausKosten;
        this.xCoord = xKoord;
        this.yCoord = yKoord;
    }*/

    public static String getFieldName () {
        return name;
    }

    public int getFieldNumber()
    {
        return fieldNumber;
    }

    public int getxCoord()
    {
        return xCoord;
    }

    public int getyCoord()
    {
        return yCoord;
    }

    public FieldState getFieldState () {
        return fieldState;
    }
}
