package de.mia19.game;

/**
 * Spielerzug
 */
public class Turn
{

    private boolean threeRoundsInPrison;
    private boolean rollOrBuyOut; //roll == true; BuyOut == false
    private boolean passedStart; //ja == true; nein == false
    private Player player;
    private Dice dice;


    public Turn(boolean threeRoundsInPrison, boolean rollOrBuyOut, boolean passedStart)
    {
        this.threeRoundsInPrison = threeRoundsInPrison;
        this.rollOrBuyOut = rollOrBuyOut;
        this.passedStart = passedStart;
    }


    public boolean isThreeRoundsInPrison()
    {
        if (!threeRoundsInPrison)
        {
            return false;
        }
        else
        {
            return true;
        }

    }

    //Würfelknopf wird gedrückt
    public void diceButton()
    {
        if(player.isInJail())
        {
            dice.roll();

            if(dice.isDouble())
                player.setInJail(false);
        }
        else
        {
            int number = dice.roll();
            if(dice.getDoubleInARow() <= 3)
            {
                player.move(number);
                performAction(number);
            }
            else
                player.setInJail(true);

        }
    }

    /**
     * Was passiert auf dem Feld
     * @param number
     */
    private void performAction(int number)
    {

    }

}
