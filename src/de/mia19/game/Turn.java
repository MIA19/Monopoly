package de.mia19.game;

/**
 * Spielerzug
 */
public class Turn {

    private boolean inPrison;
    private boolean threeRoundsInPrison;
    private boolean rollOrBuyOut; //roll == true; BuyOut == false
    private boolean passedStart; //ja == true; nein == false



    public Turn(boolean inPrison, boolean threeRoundsInPrison, boolean rollOrBuyOut, boolean passedStart) {
        this.inPrison = inPrison;
        this.threeRoundsInPrison = threeRoundsInPrison;
        this.rollOrBuyOut = rollOrBuyOut;
        this.passedStart = passedStart;
    }

    public boolean isInPrison(){
        if(!inPrison) {
            return false;
        }
        else
            return true;

        }

    public boolean isThreeRoundsInPrison(){
        if(!threeRoundsInPrison) {
            return false;
        }
        else{
            return true;
        }
    }
}
