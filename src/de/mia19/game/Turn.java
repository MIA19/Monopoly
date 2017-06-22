package de.mia19.game;

import javax.swing.*;
import java.lang.reflect.Array;

/**
 * Spielerzug
 */
public class Turn
{

    private boolean threeRoundsInPrison;
    private boolean passedStart; //ja == true; nein == false
    private Player player;
    private Dice dice;


    public Turn(boolean threeRoundsInPrison, boolean rollOrBuyOut, boolean passedStart)
    {
        this.threeRoundsInPrison = threeRoundsInPrison;
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



    //
    public void diceButton() {
        if (player.isInJail()) {
            if (!isThreeRoundsInPrison()) {
                Object[] buttons = {"Freikaufen", "Wuerfeln"};
                int entscheidung = JOptionPane.showOptionDialog(null, "Freikaufen oder Würfeln?", "ENTSCHEIDUNG", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, null);

                if (entscheidung == 0) {
                    dice.roll();

                    if (dice.isDouble())
                        player.setInJail(false);
                    player.move(dice.getDiceOne() + dice.getDiceTwo());
                }
            }


            int number = dice.roll();
            if (dice.getDoubleInARow() < 3) {
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
