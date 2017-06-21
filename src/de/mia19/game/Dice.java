package de.mia19.game;


import java.util.Random;

public class Dice {
    private int wuerfelEins;
    private int wuerfelZwei;
    private Player player;

    public Dice(Player player) {
        this.player = player;
    }

    public int roll(){
        //player.isInJail();
        Random wuEins = new Random();
        int wuerfelEins = wuEins.nextInt(6) + 1;
        setWuerfelEins(wuerfelEins);

        Random wuZwei = new Random();
        int wuerfelZwei = wuZwei.nextInt(6) + 1;
        setWuerfelZwei(wuerfelZwei);

        istPasch();
        return wuerfelEins + wuerfelZwei;
    }

    private boolean istPasch(){
        return wuerfelEins == wuerfelZwei;
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
