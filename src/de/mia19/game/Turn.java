package de.mia19.game;

import de.mia19.gui.GameScreen;

import javax.swing.*;

/**
 * Spielerzug
 */
public class Turn
{

    private boolean threeRoundsInPrison;
    private Dice dice;



    public Turn()
    {
        this.dice = new Dice(Game.getInstance().getActivePlayer());
        spielerzug();
    }

    private void isPassedStart()
    {


        if(Game.getInstance().getActivePlayer().getPosition() > 40) {
            Game.getInstance().getActivePlayer().addMoney(200);
            Stats.increaseUeberlos();
        }



    }

    public boolean isThreeRoundsInPrison()
    {
        return threeRoundsInPrison;

    }



    public void spielerzug()
    {

        if (Game.getInstance().getActivePlayer().isInJail())
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
                            Game.getInstance().getActivePlayer().setInJail(true);
                            Game.getInstance().nextPlayer();
                            //TODO: END TURN
                        }

                    }

                } else if (entscheidung == 0)
                {
                    Game.getInstance().getActivePlayer().removeMoney(50);
                    Game.getInstance().getActivePlayer().setInJail(false);
                    wuerfeln();
                }
            }
            if (isThreeRoundsInPrison())
            {

                wuerfeln();
            }
        }

        if (!Game.getInstance().getActivePlayer().isInJail())
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

        GameScreen.buybtn.setEnabled(false);

        switch (field.getFieldState())
        {
            case startField:
                if (Game.getInstance().DOUBLE_MONEY)
                {
                    Game.getInstance().getActivePlayer().addMoney(400);
                } else
                {
                    Game.getInstance().getActivePlayer().addMoney(200);
                }
                break;
            case normalStreetsBlue:
            case normalStreetsDarkBlue:
                if (!field.hasFieldOwner ())
                {
                    Game.getInstance().buyButton.setEnabled (true);
                }

                if (Game.getInstance().getActivePlayer() != field.getFieldOwner() && !field.getFieldOwner().isInJail())
                {
                    field.getFieldOwner().addMoney(field.getPrice());
                    Game.getInstance().getActivePlayer().removeMoney(field.getPrice());
                }
                break;
            case trainStation:
                if(!field.hasFieldOwner()){
                    Game.getInstance().buyButton.setEnabled(true);
                    if(Game.getInstance().getActivePlayer().getMoney() >= field.getPrice()){

                    }
                }
                if (Game.getInstance().getActivePlayer() != field.getFieldOwner() && !field.getFieldOwner().isInJail()) {
                    if (Game.getInstance().getTrainstationCount(field.getFieldOwner()) == 1) {
                        field.getFieldOwner().addMoney(field.getPrice());
                        Game.getInstance().getActivePlayer().removeMoney(field.getPrice());
                    }
                    if (Game.getInstance().getTrainstationCount(field.getFieldOwner()) == 2) {
                        field.getFieldOwner().addMoney(field.getPrice() * 2);
                        Game.getInstance().getActivePlayer().removeMoney(field.getPrice() * 2);
                    }
                    if (Game.getInstance().getTrainstationCount(field.getFieldOwner()) == 3) {
                        field.getFieldOwner().addMoney(field.getPrice() * 3);
                        Game.getInstance().getActivePlayer().removeMoney(field.getPrice() * 3);
                    }
                    if (Game.getInstance().getTrainstationCount(field.getFieldOwner()) == 4) {
                        field.getFieldOwner().addMoney(field.getPrice() * 4);
                        Game.getInstance().getActivePlayer().removeMoney(field.getPrice() * 4);
                    }
                }
                break;
            case workField:
                if (!field.hasFieldOwner ())
                {
                    Game.getInstance().buyButton.setEnabled (true);
                }

                if (Game.getInstance().getActivePlayer() != field.getFieldOwner() && !field.getFieldOwner().isInJail())
                {
                    if(Game.getInstance().list.get(12).getFieldOwner() == Game.getInstance().list.get(28).getFieldOwner()) {
                        rollButton();
                        if(rollButton() == 0){
                            dice.roll();
                            field.getFieldOwner().addMoney((dice.getDiceOne() + dice.getDiceTwo()) * 10);
                            Game.getInstance().getActivePlayer().removeMoney((dice.getDiceOne() + dice.getDiceTwo()) * 10);
                        }

                    }
                    else {
                        rollButton();
                        if (rollButton() == 0) {
                            dice.roll();
                            field.getFieldOwner().addMoney((dice.getDiceOne() + dice.getDiceTwo()) * 4);
                            Game.getInstance().getActivePlayer().removeMoney((dice.getDiceOne() + dice.getDiceTwo()) * 4);

                        }
                    }
                }
                break;
            case goToPrison:
                //Geh ins Gefängnis
                Game.getInstance().getActivePlayer().move (10);
                Game.getInstance().getActivePlayer().setInJail (true);
                break;
            case cardFieldE:
                ecCards.getEventcard(Game.getInstance().getActivePlayer());
                break;
            case cardFieldG:
                ecCards.getCommunitycard(Game.getInstance().getActivePlayer());
                break;
            case freeParking:
                break;
            case prison:
                break;
            case taxField:
                Game.getInstance().getActivePlayer().removeMoney(200);

        }
    }

    public void wuerfeln()
    {
        int result = rollButton();
        if(result == 0)
        {
            dice.roll();
            if (!dice.isDouble())
            {
                Game.getInstance().getActivePlayer().move(dice.getDiceOne() + dice.getDiceTwo());
                isPassedStart();
                performAction(Game.getInstance().getActivePlayer().getPosition());
                Game.getInstance().nextPlayer();
                //TODO:ZUG BEENDEN
            }
            if (dice.isDouble())
            {
                Game.getInstance().getActivePlayer().move(dice.getDiceOne() + dice.getDiceTwo());
                isPassedStart();
                performAction(Game.getInstance().getActivePlayer().getPosition());
                result = rollButton();
                if(result == 0)
                {
                    dice.roll();
                    if (!dice.isDouble())
                    {
                        Game.getInstance().getActivePlayer().move(dice.getDiceOne() + dice.getDiceTwo());
                        isPassedStart();
                        performAction(Game.getInstance().getActivePlayer().getPosition());
                        Game.getInstance().nextPlayer();
                        //TODO: ZUG BEENDEN
                    }
                    if (dice.isDouble())
                    {
                        Game.getInstance().getActivePlayer().move(dice.getDiceOne() + dice.getDiceTwo());
                        isPassedStart();
                        performAction(Game.getInstance().getActivePlayer().getPosition());
                        result = rollButton();
                        if(result == 0)
                        {
                            dice.roll();
                            if (!dice.isDouble())
                            {
                                Game.getInstance().getActivePlayer().move(dice.getDiceOne() + dice.getDiceTwo());
                                isPassedStart();
                                performAction(Game.getInstance().getActivePlayer().getPosition());
                                Game.getInstance().nextPlayer();
                                //TODO:ZUG BEENDEN
                            }
                            if (dice.isDouble())
                            {
                                Game.getInstance().getActivePlayer().setInJail(true);
                                Game.getInstance().getActivePlayer().setPosition(10);
                                Game.getInstance().nextPlayer();
                                //TODO: ZUG BEENDEN
                            }
                        }
                    }
                }

            }
        }
    }

    public int rollButton()
    {
        return JOptionPane.showOptionDialog(null, Game.getInstance().getActivePlayer().getName() + " ist am Zug!", "",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Würfeln"}, null);
    }

    public void ifPaschTrue(){
        if (dice.isDouble())
        {
            JOptionPane.showMessageDialog(null, "Du hast einen Pasch gewürfelt und kommst aus dem Gefängnis.");
            Game.getInstance().getActivePlayer().setInJail(false);
            Game.getInstance().getActivePlayer().move(dice.getDiceOne() + dice.getDiceTwo());
            isPassedStart();
            performAction(Game.getInstance().getActivePlayer().getPosition());
            Game.getInstance().nextPlayer();
            //TODO: ZUG BEENDEN
        }
    }

}
