import javax.swing.*;

/**
 * Created with IntelliJ IDEA 2016.1.3
 * Created by Lucas.Tilsner
 * Date: 17.05.2017
 * Time: 10:41
 */
public class Feld extends JButton {
    private int feldNummer;         //Nummer des Feldes
    private String name;            //Name des Feldes
    private boolean kaufbar;        //Ob das Feld Kaufbar ist oder nicht

    private int kaufPreis;          //Wie Teuer das Feld ist
    private boolean gekauft;        //Ob das Feld Gekauft ist oder Nicht

    private int counterHouse;
    private int hausKosten;

    private int xKoordinaten;
    private int yKoordinaten;

    //Constructor ohne Kaufpreis
    public Feld (int feldNummer, String name) {
        this.feldNummer = feldNummer;
        this.name = name;
        this.kaufbar = false;
        this.gekauft = false;
    }

    //Constructor mit Kaufpreis
    public Feld (int feldNummer, String name, int preis, int hausKosten, int xKoord, int yKoord) {
        this.feldNummer = feldNummer;
        this.name = name;
        this.kaufPreis = preis;
        this.kaufbar = true;
        this.gekauft = false;
        this.counterHouse = 0;
        this.hausKosten = hausKosten;
        this.xKoordinaten = xKoord;
        this.yKoordinaten = yKoord;
    }

    public void kaufeHaus (Spieler player) {
        if (gekauft) {
            if (player.getMoney () >= hausKosten && counterHouse < 5) {
                counterHouse += 1;
            }
        }
    }

    public int getFeldNummer () {
        return feldNummer;
    }

    public String getName () {
        return name;
    }

    public boolean isKaufbar () {
        return kaufbar;
    }

    public int getKaufPreis () {
        return kaufPreis;
    }

    public boolean isGekauft () {
        return gekauft;
    }

    public int getCounterHouse () {
        return counterHouse;
    }

    public int getHausKosten () {
        return hausKosten;
    }

    public int getxKoordinaten () {
        return xKoordinaten;
    }

    public int getyKoordinaten () {
        return yKoordinaten;
    }
}
