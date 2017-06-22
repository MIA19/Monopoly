package de.mia19.game;

/**
 * Created by e6_schneider on 14.06.2017.
 */
public class Eventcard {

    private long money;
    private String event;

    /**
     *
     * @param money long,der dem Geld in dem Event entspricht. bei einer erforderlichen Zahlung ist dieser Wert negativ, bei erhalt von Geld positiv.
     * @param event String eine Umschreibung des Ereignisses.
     */
    public Eventcard(int money, String event) {
        this.money = money;
        this.event = event;
    }

    public long getMoney() {
        return money;
    }

    public String getEvent() {
        return event;
    }
}
