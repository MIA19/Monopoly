package de.mia19.game;


import java.util.Random;

public class Dice {
    private int wuerfelEins;
    private int wuerfelZwei;
    private int paschInARow;
    private Player player;

    /**
     * Verbindet den Spieler mit den Würfel.
     * @param player
     */
    public Dice(Player player) {
        this.player = player;
    }

    /**
     * Würfelt mit beiden Würfeln.
     * @return gibt die Insgesamte Würfelzahl an.
     */
    public int roll(){
        Random wuEins = new Random();
        int wuerfelEins = wuEins.nextInt(6) + 1;
        setWuerfelEins(wuerfelEins);

        Random wuZwei = new Random();
        int wuerfelZwei = wuZwei.nextInt(6) + 1;
        setWuerfelZwei(wuerfelZwei);

        istPasch();
        if(paschInARow == 3){
            player.setInJail(true);
            paschInARow = 0;
        }
        return wuerfelEins + wuerfelZwei;
    }

    public boolean istPasch(){
        paschInARow += 1;
        return wuerfelEins == wuerfelZwei;
    }

    public void newPlayer(){
        paschInARow = 0;
    }

//    public int getWuerfelEins() {
//        return wuerfelEins;
//    }

    private void setWuerfelEins(int wuerfelEins) {
        this.wuerfelEins = wuerfelEins;
    }

//    public int getWuerfelZwei() {
//        return wuerfelZwei;
//    }

    private void setWuerfelZwei(int wuerfelZwei) {
        this.wuerfelZwei = wuerfelZwei;
    }
}
