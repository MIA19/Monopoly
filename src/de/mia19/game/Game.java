package de.mia19.game;

import de.mia19.gui.Theme;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class Game
{

    private static final String NAME = "Monopoly";
    private static Game instance;

    private List<Player> players;
    private Player activePlayer;
    //DEFAULT VALUES

    private long START_MONEY = 400;
    public boolean FREE_PARKING;
    public boolean DOUBLE_MONEY;

    private Thread thread;

    public synchronized void start()
    {
        instance = this;

        thread = new Thread(NAME + "_main");
        thread.start();


        players = new ArrayList<>();
        int playerCount = Integer.parseInt(JOptionPane.showInputDialog("Anzahl"));

        //TODO Player assign color automatically
        for(int i = 0;i < playerCount; i++)
        {
            players.add(new Player(Color.parseString(JOptionPane.showInputDialog("Farbe"))));

            //SETTING GAME SETTINGS
            players.get(i).setMoney(START_MONEY);
        }

        activePlayer = players.get(0);
    }

    public synchronized void stop()
    {
        try
        {
            thread.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList createFieldList(Theme gameTheme){
        final ArrayList<Object> list = new ArrayList<> ();
        if(gameTheme == Theme.original) {
            list.add (new Field ("Start", 0, 0, FieldState.startField));
            list.add (new Field ("Bad Straße", 0, 0, FieldState.normalStreets,60, 50, 10, 30,90,160,250));
            list.add (new Field ("Gemeinschaftsfeld", 0, 0, FieldState.cardField));
            list.add (new Field ("Turm Straße", 0, 0, FieldState.normalStreets, 60,50, 20,60,180,320,450));
            list.add (new Field ("Einkommensteuer", 0, 0, FieldState.taxField));
            list.add (new Field ("Süd Bahnhof", 0, 0, FieldState.trainStation, 200, 100,200,300,400));
            list.add (new Field ("Chaussee Straße", 0, 0, FieldState.normalStreets, 100, 50,30,90,270,400,550));
            list.add (new Field ("Ereignisfeld", 0, 0, FieldState.cardField));
            list.add (new Field ("Elisen Straße", 0, 0, FieldState.normalStreets, 100,50,30,90,270,400,550));
            list.add (new Field ("Post Straße", 0, 0, FieldState.normalStreets, 120,50,40,100,300,450,600));
            list.add (new Field ("Gefängnis", 0, 0, FieldState.prison));
            list.add (new Field ("See Straße", 0, 0, FieldState.normalStreets, 140,100,50,150,450,625,750));
            list.add (new Field ("Elektrizitätswerk", 0, 0, FieldState.workField));
            list.add (new Field ("Hafen Straße", 0, 0, FieldState.normalStreets,140,100,50,150,450,625,750));
            list.add (new Field ("Neue Straße", 0, 0, FieldState.normalStreets, 160,100,60,180,500,700,900));
            list.add (new Field ("West Bahnhof", 0, 0, FieldState.trainStation,200,100,200,300,400));
            list.add (new Field ("Münchener Straße", 0, 0, FieldState.normalStreets, 180,100,70,200,550,750,950));
            list.add (new Field ("Gemeinschaftsfeld", 0, 0, FieldState.cardField));
            list.add (new Field ("Wiener Straße", 0, 0, FieldState.normalStreets, 180,100,70,200,550,750,950));
            list.add (new Field ("Berliner Straße", 0, 0, FieldState.normalStreets, 200,100,80,220,600,800,1000));
            list.add (new Field ("Frei Parken", 0, 0, FieldState.freeParking));
            list.add (new Field ("Theater Straße", 0, 0, FieldState.normalStreets, 220,150,90,250,700,875,1050));
            list.add (new Field ("Ereignisfeld", 0, 0, FieldState.cardField));
            list.add (new Field ("Museums Straße", 0, 0, FieldState.normalStreets, 220,150,90,250,700,875,1050));
            list.add (new Field ("Opernplatz", 0, 0, FieldState.normalStreets,240,150,100,300,750,925,1100));
            list.add (new Field ("Nord Bahnhof", 0, 0, FieldState.trainStation,200,100,200,300,400));
            list.add (new Field ("Lessing Straße", 0, 0, FieldState.normalStreets, 260,150,110,330,800,975,1150));
            list.add (new Field ("Schiller Straße", 0, 0, FieldState.normalStreets,260,150,120,360,850,1025,1200));
            list.add (new Field ("Wasser Werk", 0, 0, FieldState.workField));
            list.add (new Field ("Goethe Straße", 0, 0, FieldState.normalStreets,280,150,110,330,800,975,1150));
            list.add (new Field ("Gehe ins Gefängnis", 0, 0, FieldState.goToPrison));
            list.add (new Field ("Rathaus Platz", 0, 0, FieldState.normalStreets,300,200,130,390,900,1100,1275));
            list.add (new Field ("Haupt Straße", 0, 0, FieldState.normalStreets,300,200,130,390,900,1100,1275));
            list.add (new Field ("Gemeinschaftsfeld", 0, 0, FieldState.cardField));
            list.add (new Field ("Bahnhof Straße", 0, 0, FieldState.normalStreets, 320,200,150,450,1000,1200,1400));
            list.add (new Field ("Haupt Bahnhof", 0, 0, FieldState.trainStation,200,100,200,300,400));
            list.add (new Field ("Ereignisfeld", 0, 0, FieldState.cardField));
            list.add (new Field ("Park Straße", 0, 0, FieldState.normalStreets, 350,200,175,500,1100,1300,1500));
            list.add (new Field ("Zusatzsteuer", 0, 0, FieldState.taxField));
            list.add (new Field ("Schloss Allee", 0, 0, FieldState.normalStreets,400,200,200,600,1400,1700,2000));
        }else if(gameTheme == Theme.lette){
            list.add (new Field ("Start", 0, 0, FieldState.startField));
            list.add (new Field ("Bäcker", 0, 0, FieldState.normalStreets));
            list.add (new Field ("Gemeinschaftsfeld", 0, 0, FieldState.cardField));
            list.add (new Field ("Mensa", 0, 0, FieldState.normalStreets));
            list.add (new Field ("Einkommensteuer", 0, 0, FieldState.taxField));
            list.add (new Field ("Haupteingang", 0, 0, FieldState.trainStation));
            list.add (new Field ("Animationstechnik", 0, 0, FieldState.normalStreets));
            list.add (new Field ("Ereignisfeld", 0, 0, FieldState.cardField));
            list.add (new Field ("Sensortechnik", 0, 0, FieldState.normalStreets));
            list.add (new Field ("Digitaltechnik", 0, 0, FieldState.taxField));
            list.add (new Field ("Mathe", 0, 0, FieldState.prison));
            list.add (new Field ("", 0, 0, FieldState.normalStreets));
            list.add (new Field ("Elektrizitätsraum", 0, 0, FieldState.taxField));
            list.add (new Field ("", 0, 0, FieldState.normalStreets));
            list.add (new Field ("", 0, 0, FieldState.normalStreets));
            list.add (new Field ("Westeingang", 0, 0, FieldState.trainStation));
            list.add (new Field ("", 0, 0, FieldState.normalStreets));
            list.add (new Field ("Gemeinschaftsfeld", 0, 0, FieldState.cardField));
            list.add (new Field ("", 0, 0, FieldState.normalStreets));
            list.add (new Field ("", 0, 0, FieldState.normalStreets));
            list.add (new Field ("Chillraum", 0, 0, FieldState.freeParking));
            list.add (new Field ("", 0, 0, FieldState.normalStreets));
            list.add (new Field ("Ereignisfeld", 0, 0, FieldState.cardField));
            list.add (new Field ("Digitaltechnik", 0, 0, FieldState.taxField));
            list.add (new Field ("Digitaltechnik", 0, 0, FieldState.taxField));
            list.add (new Field ("Digitaltechnik", 0, 0, FieldState.taxField));
            list.add (new Field ("Digitaltechnik", 0, 0, FieldState.taxField));
            list.add (new Field ("Digitaltechnik", 0, 0, FieldState.taxField));
            list.add (new Field ("Digitaltechnik", 0, 0, FieldState.taxField));
            list.add (new Field ("Digitaltechnik", 0, 0, FieldState.taxField));
            list.add (new Field ("Digitaltechnik", 0, 0, FieldState.taxField));
            list.add (new Field ("Digitaltechnik", 0, 0, FieldState.taxField));
        }

        return list;
    }
}
