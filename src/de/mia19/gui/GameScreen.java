package de.mia19.gui;

import de.mia19.RessourceLoader;
import de.mia19.game.Field;
import de.mia19.game.FieldState;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameScreen extends JFrame
{
    public GameScreen(String theme)
    {
        final ArrayList<Field> allFields = createFieldList();


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

    public ArrayList createFieldList(){
        final ArrayList<Object> list = new ArrayList<> ();
        list.add (new Field ("Start",0,0, FieldState.startField));
        list.add (new Field ("Bad Straße",0,0, FieldState.normalStreets));
        list.add (new Field ("GemeinschaftsFeld",0,0, FieldState.cardField));
        list.add (new Field ("Turm Straße",0,0, FieldState.normalStreets));
        list.add (new Field ("Einkommensteuer",0,0, FieldState.taxField));
        list.add (new Field ("Süd Bahnhof",0,0, FieldState.trainStation));
        list.add (new Field ("Chaussee Straße",0,0, FieldState.normalStreets));
        list.add (new Field ("EreignisFeld",0,0, FieldState.cardField));
        list.add (new Field ("Elisen Straße",0,0, FieldState.normalStreets));
        list.add (new Field ("Post Straße",0,0, FieldState.normalStreets));
        list.add (new Field ("Gefängnis",0,0, FieldState.prison));
        list.add (new Field ("See Straße",0,0, FieldState.normalStreets));
        list.add (new Field ("Elektrizitätswerk",0,0, FieldState.workField));
        list.add (new Field ("Hafen Straße",0,0, FieldState.normalStreets));
        list.add (new Field ("Neue Straße",0,0, FieldState.normalStreets));
        list.add (new Field ("West Bahnhof",0,0, FieldState.trainStation));
        list.add (new Field ("Münchener Straße",0,0, FieldState.normalStreets));
        list.add (new Field ("Gemeinschaftsfeld",0,0, FieldState.cardField));
        list.add (new Field ("Wiener Straße",0,0, FieldState.normalStreets));
        list.add (new Field ("Berliner Straße",0,0, FieldState.normalStreets));
        list.add (new Field ("Frei Parken",0,0, FieldState.freeParking));
        list.add (new Field ("Theater Straße",0,0, FieldState.normalStreets));
        list.add (new Field ("Ereignisfeld",0,0, FieldState.cardField));
        list.add (new Field ("Museums Straße",0,0, FieldState.normalStreets));
        list.add (new Field ("Opernplatz",0,0, FieldState.normalStreets));
        list.add (new Field ("Nord Bahnhof",0,0, FieldState.trainStation));
        list.add (new Field ("Lessing Straße",0,0, FieldState.normalStreets));
        list.add (new Field ("Schiller Straße",0,0, FieldState.normalStreets));
        list.add (new Field ("Wasser Werk",0,0, FieldState.workField));
        list.add (new Field ("Goethe Straße",0,0, FieldState.normalStreets));
        list.add (new Field ("Gehe ins Gefängnis",0,0, FieldState.goToPrison));
        list.add (new Field ("Rathaus Platz",0,0, FieldState.normalStreets));
        list.add (new Field ("Haupt Straße",0,0, FieldState.normalStreets));
        list.add (new Field ("GemeinschaftsFeld",0,0, FieldState.cardField));
        list.add (new Field ("Bahnhof Straße",0,0, FieldState.normalStreets));
        list.add (new Field ("Haupt Bahnhof",0,0, FieldState.trainStation));
        list.add (new Field ("Ereignisfeld",0,0, FieldState.cardField));
        list.add (new Field ("Park Straße",0,0, FieldState.normalStreets));
        list.add (new Field ("Zusatzsteuer",0,0, FieldState.taxField));
        list.add (new Field ("Schloss Allee",0,0, FieldState.normalStreets));

        return list;
    }
}
