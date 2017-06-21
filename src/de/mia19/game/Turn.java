package de.mia19.game;

/**
 * Spielerzug
 */
public class Turn {

    private boolean threeRoundsInPrison;
    private boolean rollOrBuyOut; //roll == true; BuyOut == false
    private boolean passedStart; //ja == true; nein == false
    private Player player;
    private Dice dice;


    public Turn(boolean threeRoundsInPrison, boolean rollOrBuyOut, boolean passedStart) {
        this.threeRoundsInPrison = threeRoundsInPrison;
        this.rollOrBuyOut = rollOrBuyOut;
        this.passedStart = passedStart;
    }




    public boolean isThreeRoundsInPrison(){
        if(!threeRoundsInPrison) {
            return false;
        }
        else{
            return true;
        }

    }

    public int move(){
        //brauche die Koordinaten

    }

    //Würfelknopf wird gedrückt
    public void diceButton(){
        dice.roll();
        if(dice.istPasch()){
            dice.roll();
            if(dice.istPasch()){
                dice.roll();
                if(dice.istPasch()){
                    player.setInJail(true);
                }
            }
        }
        else{
            player. //Move methode noch nicht fertig
        }
    }


}
