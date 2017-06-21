package de.mia19.gui;

import de.mia19.RessourceLoader;
import de.mia19.game.Field;
import de.mia19.game.FieldState;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameScreen extends JFrame
{
    public GameScreen(String theme, Theme gameTheme)
    {
        final ArrayList<Field> allFields = createFieldList(gameTheme);


        this.setSize(1000, 820);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Monopoly");
        final JLabel feld = new JLabel();
        final ImageIcon spielFeld = new ImageIcon(RessourceLoader.getImage( theme + ".jpg"));
        feld.setIcon(spielFeld);
        this.add(feld);
        final JPanel eastSide = createRightSide();
        this.add(eastSide, BorderLayout.EAST);
    }

    public JPanel createRightSide()
    {
        final JPanel panel = new JPanel();

        final JPanel buttonsDown = new JPanel();
        buttonsDown.setLayout(new GridLayout(2, 2));
        final JButton wüfeln = new JButton("Würfeln");
        final JButton kaufen = new JButton("kaufen");
        final JButton bezahlen = new JButton("bezahlen");
        final JButton zugBeenden = new JButton("Ende");
        buttonsDown.add(wüfeln);
        buttonsDown.add(kaufen);
        buttonsDown.add(bezahlen);
        buttonsDown.add(zugBeenden);
        panel.add(buttonsDown, BorderLayout.SOUTH);

        return panel;
    }

    public ArrayList createFieldList(Theme gameTheme){
        final ArrayList<Object> list = new ArrayList<> ();
        if(gameTheme == Theme.original) {
            list.add (new Field ("Start", 0, 0, FieldState.startField));
            list.add (new Field ("Bad Straße", 0, 0, FieldState.normalStreets,60, 50, 10, 30,90,160,250));
            list.add (new Field ("GemeinschaftsFeld", 0, 0, FieldState.cardField));
            list.add (new Field ("Turm Straße", 0, 0, FieldState.normalStreets, 60,50, 20,60,180,320,450));
            list.add (new Field ("Einkommensteuer", 0, 0, FieldState.taxField));
            list.add (new Field ("Süd Bahnhof", 0, 0, FieldState.trainStation, 200, 100,200,300,400));
            list.add (new Field ("Chaussee Straße", 0, 0, FieldState.normalStreets, 100, 50,30,90,270,400,550));
            list.add (new Field ("EreignisFeld", 0, 0, FieldState.cardField));
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
            list.add (new Field ("GemeinschaftsFeld", 0, 0, FieldState.cardField));
            list.add (new Field ("Bahnhof Straße", 0, 0, FieldState.normalStreets, 320,200,150,450,1000,1200,1400));
            list.add (new Field ("Haupt Bahnhof", 0, 0, FieldState.trainStation,200,100,200,300,400));
            list.add (new Field ("Ereignisfeld", 0, 0, FieldState.cardField));
            list.add (new Field ("Park Straße", 0, 0, FieldState.normalStreets, 350,200,175,500,1100,1300,1500));
            list.add (new Field ("Zusatzsteuer", 0, 0, FieldState.taxField));
            list.add (new Field ("Schloss Allee", 0, 0, FieldState.normalStreets,400,200,200,600,1400,1700,2000));
        }else if(gameTheme == Theme.lette){
            list.add (new Field ("Start", 0, 0, FieldState.startField));
        }

        return list;
    }
}
