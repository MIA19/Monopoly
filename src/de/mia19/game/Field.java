package de.mia19.game;


import javax.swing.*;

public class Field extends JButton
{
    private static int fieldCount;
    private int fieldNumber; //Nummer des Feldes

    private int xCoord;
    private int yCoord;

    public Field(int xCoord, int yCoord)
    {
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
}
