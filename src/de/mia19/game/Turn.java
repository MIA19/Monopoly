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
    public boolean imBesitz;

    public Turn(Player player)
    {
        this.player = player;

    }

    private boolean isPassedStart()
    {
        if (passedStart)
        {
            player.addMoney(200);
            return true;

        } else
        {
            return false;
        }
    }

    public boolean isThreeRoundsInPrison()
    {
        return threeRoundsInPrison;

    }


    //
    public void Spielerzug()
    {
        if (player.isInJail())
        {
            if (!isThreeRoundsInPrison())
            {
                Object[] buttons = {"Freikaufen", "Wuerfeln"};
                int entscheidung = JOptionPane.showOptionDialog(null, "Freikaufen oder Würfeln?", "ENTSCHEIDUNG",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, null);

                if (entscheidung == 1)
                {

                    dice.roll();

                    ifPaschTrue();
                }
                if (!dice.isDouble())
                {
                    JOptionPane.showMessageDialog(null, "Kein Pasch, versuchs nochmal!");
                    rollButton();
                    if (rollButton() == 0)
                    {
                        dice.roll();
                        ifPaschTrue();
                    }
                    if (!dice.isDouble())
                    {
                        JOptionPane.showMessageDialog(null, "Kein Pasch, versuchs nochmal!");
                        rollButton();
                        if (rollButton() == 0)
                        {
                            dice.roll();
                            ifPaschTrue();
                        }
                        if (!dice.isDouble())
                        {
                            JOptionPane.showMessageDialog(null, "Kein Pasch nach 3 versuchen, du bleibst im Gefängnis.");
                            player.setInJail(true);

                            //TODO: END TURN UND NÄCHSTER SPIELER IST DRAN
                        }

                    }

                } else if (entscheidung == 0)
                {
                    player.removeMoney(50);
                    player.setInJail(false);
                    wuerfeln();
                }
            }
            if (isThreeRoundsInPrison())
            {

                wuerfeln();
            }
        }

        if (!player.isInJail())
        {
            wuerfeln();
        }
    }





    /**
     * Was passiert auf dem Feld
     *
     * @param number
     */
    private void performAction(int number)
    {
        ECCards ecCards = new ECCards();
        Field field = Field.getFromNumber(number);
        Game game = Game.instance;
        game.buyButton.setEnabled(false);
        switch (field.getFieldState())
        {
            case startField:
                if (game.DOUBLE_MONEY)
                {
                    player.addMoney(400);
                } else
                {
                    player.addMoney(200);
                }
                break;
            case normalStreets:
                if (!field.hasFieldOwner ())
                {
                    game.buyButton.setEnabled (true);
                }

                if (player != field.getFieldOwner() && !field.getFieldOwner().isInJail())
                {
                    /*if(game.list.get(5).getFieldOwner() == game.list.get(15).getFieldOwner())
                    field.getFieldOwner ().addMoney (field.getPrice ());
                    player.removeMoney (field.getPrice ());
                    game.buyButton.setEnabled (false);*/
                }
                break;
            case trainStation:
                if(!field.hasFieldOwner()){
                    game.buyButton.setEnabled(true);
                }
                break;
            case workField:
                if (!field.hasFieldOwner ())
                {
                    game.buyButton.setEnabled (true);
                }

                if (player != field.getFieldOwner() && !field.getFieldOwner().isInJail())
                {
                    if(game.list.get(12).getFieldOwner() == game.list.get(28).getFieldOwner()) {
                        rollButton();
                        if(rollButton() == 0){
                            dice.roll();
                            field.getFieldOwner().addMoney((dice.getDiceOne() + dice.getDiceTwo()) * 10);
                            player.removeMoney((dice.getDiceOne() + dice.getDiceTwo()) * 10);
                        }

                    }
                    else {
                        rollButton();
                        if (rollButton() == 0) {
                            dice.roll();
                            field.getFieldOwner().addMoney((dice.getDiceOne() + dice.getDiceTwo()) * 4);
                            player.removeMoney((dice.getDiceOne() + dice.getDiceTwo()) * 4);

                        }
                    }
                }
                break;
            case goToPrison:
                //Geh ins Gefängnis
                player.move (10);
                player.setInJail (true);
                break;
            case cardFieldE:
                ecCards.getEventcard(player);
                break;
            case cardFieldG:
                ecCards.getCommunitycard(player);
                break;
            case freeParking:
                break;
            case prison:
                break;
            case taxField:
                player.removeMoney(200);

        }
    }

    public void wuerfeln()
    {
        rollButton();
        if(rollButton() == 0)
        {
            dice.roll();
            if (!dice.isDouble())
            {
                player.move(dice.getDiceOne() + dice.getDiceTwo());
                isPassedStart();
                //TODO: SCHAUEN AUF WELCHEN FELD, AKTION AUSFÜHREN, ZUG BEENDEN UND NÄCHSTER SPIELER IST DRAN
            }
            if (dice.isDouble())
            {
                player.move(dice.getDiceOne() + dice.getDiceTwo());
                isPassedStart();
                //TODO: SCHAUEN AUF WELCHEN FELD, AKTION AUSFÜHREN
                rollButton();
                if(rollButton() == 0)
                {
                    dice.roll();
                    if (!dice.isDouble())
                    {
                        player.move(dice.getDiceOne() + dice.getDiceTwo());
                        isPassedStart();
                        //TODO: SCHAUEN AUF WELCHEN FELD, AKTION AUSFÜHREN, ZUG BEENDEN UND NÄCHSTER SPIELER IST DRAN
                    }
                    if (dice.isDouble())
                    {
                        player.move(dice.getDiceOne() + dice.getDiceTwo());
                        isPassedStart();
                        //TODO: SCHAUEN AUF WELCHEN FELD, AKTION AUSFÜHREN
                        rollButton();
                        if(rollButton() == 0)
                        {
                            dice.roll();
                            if (!dice.isDouble())
                            {
                                player.move(dice.getDiceOne() + dice.getDiceTwo());
                                isPassedStart();
                                //TODO: SCHAUEN AUF WELCHEN FELD, AKTION AUSFÜHREN, ZUG BEENDEN UND NÄCHSTER SPIELER IST DRAN
                            }
                            if (dice.isDouble())
                            {
                                player.setInJail(true);
                                //TODO: SPIELER INS GEFÄNGNIS BEWEGEN, ZUG BEENDEN, NÄCHSTER SPIELER IST DRAN
                            }
                        }
                    }
                }

            }
        }
    }

    public int rollButton()
    {
        Object[] wuerfeln = {"Würfeln"};
        return JOptionPane.showOptionDialog(null, player.getColor().getName() + " ist am Zug!", "",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, wuerfeln, null);
    }

    public void ifPaschTrue(){
        if (dice.isDouble())
        {
            JOptionPane.showMessageDialog(null, "Du hast einen Pasch gewürfelt und kommst aus dem Gefängnis.");
            player.setInJail(false);
            player.move(dice.getDiceOne() + dice.getDiceTwo());
            isPassedStart();
            //TODO: SCHAUEN AUF WELCHEN FELD, AKTION AUSFÜHREN, ZUG BEENDEN UND NÄCHSTER SPIELER IST DRAN
        }
    }

}
