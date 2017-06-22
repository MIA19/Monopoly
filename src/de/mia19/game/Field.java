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
    private int trainstation[] = new int[4];
    private int costPerHouse;
    private int withHouses[] = new int[5];


    /**
     * Constructor for all Streets
      * @param name
     * @param xCoord
     * @param yCoord
     * @param fieldState
     * @param fieldPrice
     * @param houseCost
     * @param withOneHouse
     * @param withTwoHouses
     * @param withThreeHouses
     * @param withFourHouses
     * @param withVilla
     */
    public Field(String name, int xCoord, int yCoord, FieldState fieldState, int fieldPrice, int houseCost, int withOneHouse, int withTwoHouses, int withThreeHouses, int withFourHouses, int withVilla)
    {
        this.name = name;
        this.fieldNumber = Field.fieldCount + 1;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.fieldState = fieldState;
        this.price = fieldPrice;
        if(fieldState.isBuyAble ()){
            this.costPerHouse = houseCost;
            this.withHouses[0] = withOneHouse;
            this.withHouses[1] = withTwoHouses;
            this.withHouses[2] = withThreeHouses;
            this.withHouses[3] = withFourHouses;
            this.withHouses[4] = withVilla;
        }
    }

    /**
     * Constructor for all normal fields
     * @param name
     * @param xCoord
     * @param yCoord
     * @param fieldState
     */
    public Field (String name, int xCoord, int yCoord, FieldState fieldState) {
        this.name = name;
        this.fieldNumber = Field.fieldCount + 1;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.fieldState = fieldState;
    }

    /**
     * Constructor for all trainstations
     * @param name
     * @param xCoord
     * @param yCoord
     * @param fieldState
     * @param fieldPrice
     */
    public Field (String name, int xCoord, int yCoord, FieldState fieldState, int fieldPrice, int oneStation, int twoStations, int threeStations, int allStations) {
        this.name = name;
        this.fieldNumber = Field.fieldCount + 1;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.fieldState = fieldState;
        this.price = fieldPrice;
        this.trainstation[0] = oneStation;
        this.trainstation[1] = twoStations;
        this.trainstation[2] = threeStations;
        this.trainstation[3] = allStations;
    }
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

    public static int getFieldCount () {
        return fieldCount;
    }

    public int getPrice () {
        return price;
    }

    public int[] getTrainstation () {
        return trainstation;
    }

    public int getCostPerHouse () {
        return costPerHouse;
    }

    public int[] getWithHouses () {
        return withHouses;
    }

    public static Field getFromNumber(int fieldNumber)
    {
        for(Field field : Game.instance.fields)
        {
            if(field.getFieldNumber() == fieldNumber)
                return field;
        }

        return null;
    }
}
