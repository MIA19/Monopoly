/**
 * Created with IntelliJ IDEA 2016.1.3
 * Created by Lucas.Tilsner
 * Date: 31.05.2017
 * Time: 09:50
 */
public class Spieler {
    private String name;
    private int money;
    private int position;

    public Spieler (String name, int money, int position) {
        this.name = name;
        this.money = money;
        this.position = position;
    }

    public String getName () {
        return name;
    }

    public int getMoney () {
        return money;
    }

    public int getPosition () {
        return position;
    }
}
