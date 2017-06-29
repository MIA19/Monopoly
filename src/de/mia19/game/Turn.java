package de.mia19.game;

import javax.swing.*;
import java.lang.reflect.Array;

/**
 * Spielerzug
 */
public class Turn {

    private boolean threeRoundsInPrison;
    private boolean passedStart; //ja == true; nein == false
    private Player player;
    private Dice dice;
    public boolean imBesitz;

    public Turn() {


    }

    private boolean isPassedStart(){
        if(passedStart){
           player.addMoney(200);
            return true;

        }
        else{
            return false;
        }
    }

    public boolean isThreeRoundsInPrison() {
        if (!threeRoundsInPrison) {
            return false;
        } else {
            return true;
        }

    }


    //
    public void istSpielerImGefängnis() {
        if (player.isInJail()) {
            if (!isThreeRoundsInPrison()) {
                Object[] buttons = {"Freikaufen", "Wuerfeln"};
                int entscheidung = JOptionPane.showOptionDialog(null, "Freikaufen oder Würfeln?", "ENTSCHEIDUNG",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, null);

                if (entscheidung == 1) {
                    dice.roll();

                    if (dice.isDouble())
                        player.setInJail(false);
                    player.move(dice.getDiceOne() + dice.getDiceTwo());
                    isPassedStart();
                    //TODO: SCHAUEN AUF WELCHEN FELD, AKTION AUSFÜHREN, ZUG BEENDEN UND NÄCHSTER SPIELER IST DRAN

                    if (!dice.isDouble()) {
                        int i = rollButton();
                        if(i == 0) {
                            dice.roll();
                        }

                        if (dice.isDouble()) {
                            player.setInJail(false);
                            player.move(dice.getDiceOne() + dice.getDiceTwo());
                            isPassedStart();
                            //TODO: SCHAUEN AUF WELCHEN FELD, AKTION AUSFÜHREN, ZUG BEENDEN UND NÄCHSTER SPIELER IST DRAN
                        }
                        if (!dice.isDouble()) {
                            dice.roll();

                            if (dice.isDouble()) {
                                player.setInJail(false);
                                player.move(dice.getDiceOne() + dice.getDiceTwo());
                                isPassedStart();
                                //TODO: SCHAUEN AUF WELCHEN FELD, AKTION AUSFÜHREN, ZUG BEENDEN UND NÄCHSTER SPIELER IST DRAN
                            }
                            if (!dice.isDouble()) {
                                player.setInJail(true);

                                //TODO: END TURN UND NÄCHSTER SPIELER IST DRAN
                            }
                        }

                    } else if (entscheidung == 0) {
                        player.removeMoney(50);
                        player.setInJail(false);
                        dice.roll();
                        if (dice.isDouble()) {
                            player.move(dice.getDiceOne() + dice.getDiceTwo());
                            isPassedStart();
                            player.getPosition();
                        } else {
                            player.move(dice.getDiceOne() + dice.getDiceTwo());
                            isPassedStart();
                        }
                    }
                }


                /*int number = dice.roll();
                if (dice.getDoubleInARow() < 3) {
                    player.move(number);
                    performAction(number);
                } else
                    player.setInJail(true);*/

            }
            if (isThreeRoundsInPrison()) {
                wuerfeln();
            }
        }
        if (!player.isInJail()) {
            wuerfeln();
        }
    }


    /**
     * Was passiert auf dem Feld
     *
     * @param number
     */
    private void performAction(int number) {
        Field field = Field.getFromNumber(number);
        switch (field.getFieldState()) {
            case startField:
                Game game = new Game();
                if (game.DOUBLE_MONEY) {
                    player.addMoney(400);
                } else {
                    player.addMoney(200);
                }
            case trainStation:

        }
    }


    public void wuerfeln() {
        dice.roll();
        if (!dice.isDouble()) {
            player.move(dice.getDiceOne() + dice.getDiceTwo());
            isPassedStart();
            //TODO: SCHAUEN AUF WELCHEN FELD, AKTION AUSFÜHREN, ZUG BEENDEN UND NÄCHSTER SPIELER IST DRAN
        }
        if (dice.isDouble()) {
            player.move(dice.getDiceOne() + dice.getDiceTwo());
            isPassedStart();
            //TODO: SCHAUEN AUF WELCHEN FELD, AKTION AUSFÜHREN
            dice.roll();

            if (!dice.isDouble()) {
                player.move(dice.getDiceOne() + dice.getDiceTwo());
                isPassedStart();
                //TODO: SCHAUEN AUF WELCHEN FELD, AKTION AUSFÜHREN, ZUG BEENDEN UND NÄCHSTER SPIELER IST DRAN
            }
            if (dice.isDouble()) {
                player.move(dice.getDiceOne() + dice.getDiceTwo());
                isPassedStart();
                //TODO: SCHAUEN AUF WELCHEN FELD, AKTION AUSFÜHREN
                dice.roll();
                if (!dice.isDouble()) {
                    player.move(dice.getDiceOne() + dice.getDiceTwo());
                    isPassedStart();
                    //TODO: SCHAUEN AUF WELCHEN FELD, AKTION AUSFÜHREN, ZUG BEENDEN UND NÄCHSTER SPIELER IST DRAN
                }
                if (dice.isDouble()) {
                    player.setInJail(true);
                    //TODO: SPIELER INS GEFÄNGNIS BEWEGEN, ZUG BEENDEN, NÄCHSTER SPIELER IST DRAN
                }
            }

        }
    }
    public int rollButton() {
        Object[] wuerfeln = {"Würfeln"};
        return JOptionPane.showOptionDialog(null, player.getColor().name() + " ist am Zug!", "WÜRFELN",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, wuerfeln, null);
    }
}

