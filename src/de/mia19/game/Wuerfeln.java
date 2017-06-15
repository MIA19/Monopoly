package de.mia19.game;

import java.util.Random;


public class Wuerfeln {
    private int wuerfelEins;
    private int wuerfelZwei;

    public int wirdGewuerfelt(){

        Random wuEins = new Random();
        int wuerfelEins = wuEins.nextInt(6) + 1;
        setWuerfelEins(wuerfelEins);

        Random wuZwei = new Random();
        int wuerfelZwei = wuZwei.nextInt(6) + 1;
        setWuerfelZwei(wuerfelZwei);

        return wuerfelEins + wuerfelZwei;
    }

    public boolean istPasch(){
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
