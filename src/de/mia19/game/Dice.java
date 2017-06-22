package de.mia19.game;


import java.util.Random;

public class Dice {
    private int diceOne;
    private int diceTwo;

    /**
     * Verbindet den Spieler mit den Würfel.
     *
     */
    public Dice() {
    }

    /**
     * Würfelt mit beiden Würfeln.
     * @return gibt die Insgesamte Würfelzahl an.
     */
    public int roll(){
        Random random = new Random();
        this.diceOne = random.nextInt(6) + 1;
        this.diceTwo = random.nextInt(6) + 1;

        return diceOne + diceTwo;
    }

    /**
     *
     * @return falls True ist es ein Pasch, falls False ist es kein Pasch.
     */
    public boolean isDouble(){
        return diceOne == diceTwo;
    }



    /**
     * Wenn ein Neuer Spieler am zug ist, werden die Eigenschaften zurückgesetzt.
     */
//    public void newPlayer(){
//    }

//    public int getDoubleInARow()
//    {
//        return doubleInARow;
//    }
}
