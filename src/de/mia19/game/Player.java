package de.mia19.game;

import de.mia19.RessourceLoader;

import javax.swing.*;

/**
 * Spieler Klasse
 */
public class Player {
    private static String playerName;
    private GameColor gameColor;
    private long money;
    private int position;
    private boolean inJail;

    public Player(GameColor gameColor, String name) {
        this.gameColor = gameColor;
        this.position = 0;
        this.playerName = name;
    }

    public String getName() {
        return playerName;
    }

    public GameColor getGameColor() {
        return gameColor;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public void addMoney(long money) {
        this.money += money;
    }

    public void removeMoney(long money) {
        this.money -= money;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
        //   this.position = 10;
    }

    public boolean isInJail() {
        return inJail;
    }

    public void move(int fields) {
        //TODO NEU ANFANG ÜBER LOS
        this.position += fields;
    }

    public void pay(Player to, long amount) {
        if ((money - amount) < 0) {
            to.addMoney(money);
            removeMoney(amount);
            //TODO LOST
        } else {
            to.addMoney(amount);
            removeMoney(amount);
        }
    }

    public int getCountOfOwnedColorStreets(FieldState fieldState) {
        int i = 0;
        for (Field field : Game.getInstance().getOwnedFieldsByPlayer(this)) {
            if (field.getFieldState().equals(fieldState))
                i++;
        }
        return i;
    }

    public boolean hasAllStreetsOfColor(FieldState fieldState) {
        return getCountOfOwnedColorStreets(fieldState) == Game.getInstance().getCountOfMaxStreetColor(fieldState);
    }

    public ImageIcon getIcon()
    {
        return new ImageIcon(RessourceLoader.getImage("figureColors/" + gameColor.getName() + ".png"));
    }
}
