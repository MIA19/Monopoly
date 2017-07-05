package de.mia19.game;

import com.sun.jmx.remote.security.JMXPluggableAuthenticator;
import com.sun.xml.internal.bind.v2.TODO;
import de.mia19.gui.Theme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class Game
{

    private static final String NAME = "Monopoly";
    public static Game instance;
    public ArrayList<Field> fields;


    private List<Player> players;
    private Player activePlayer;
    public JButton buyButton;

    //DEFAULT VALUES

    private long START_MONEY = 400;
    public boolean FREE_PARKING;
    public boolean DOUBLE_MONEY;
    public ArrayList<Field> list;
    private Thread thread;
    public Theme theme = Theme.original;

    public Game()
    {
        instance = this;
        createFieldList(theme);
    }


    public synchronized void start()
    {

        thread = new Thread(NAME + "_main");
        thread.start();


        players = new ArrayList<>();
        buyButton = new JButton ();
        buyButton.setEnabled (false);

        /**
         * Die Combobox für die Anzahl der Spieler!
         */
        JLabel aussage = new JLabel("Wähle die Anzahl der Spieler!");

        Integer[] comboBoxListe = {
                1, 2, 3, 4, 5, 6};

        JComboBox spielerAuswahl = new JComboBox(comboBoxListe);
        final JComponent[] inputs = new JComponent[]{
                aussage,
                spielerAuswahl
        };

        JOptionPane.showConfirmDialog(null, inputs, "Game Settings", JOptionPane.OK_CANCEL_OPTION);
        int playerCount = (int) spielerAuswahl.getSelectedItem();


        //TODO: JButton und actionListener die Farben reinmachen dies das du weißt amina flikflak!
        JFrame playerFrame = new JFrame("Monopoly");
        playerFrame.setSize(500, 50 +50* playerCount);

        JPanel playerPanel = new JPanel(new GridLayout(2 +playerCount, 2));
        JButton readyButton = new JButton("Starten");
        JLabel playerName = new JLabel("Geben Sie die Spielernamen ein!");
        playerPanel.add(playerName);
        playerPanel.add(new JLabel());
        String[] spielerNamen = {
          "Spieler 1", "Spieler 2", "Spieler 3", "Spieler 4", "Spieler 5", "Spieler 6"
        };

        ArrayList<JTextField> alleTextFelder = new ArrayList<>();

        for (int i = 0; i < playerCount; i++)
        {
           playerPanel.add(new JLabel(spielerNamen[i]));
            JTextField textfield = new JTextField();
            playerPanel.add(textfield);
            alleTextFelder.add(textfield);
        }
        playerPanel.add(readyButton);
        playerFrame.add(playerPanel);
        playerFrame.setVisible(true);




    readyButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        playerFrame.setVisible(false);
        String[] farben = new String[6];
        farben[0] = "blue";
        farben[1] = "red";
        farben[2] = "green";
        farben[3] = "yellow";
        farben[4] = "black";
        farben[5] = "white";
        for (int i = 0; i < playerCount; i++)
        {
            String name = alleTextFelder.get(i).getText();
            players.add(new Player(Color.parseString(farben[i]), name));
            //SETTING GAME SETTINGS
            players.get(i).setMoney(START_MONEY);
        }

        activePlayer = players.get(0);
        }
    });
    }

    public synchronized void stop()
    {
        try
        {
            thread.join();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }


    public Player getActivePlayer()
    {
        return activePlayer;
    }

    public void nextPlayer()
    {
        for (int i = 0; i < players.size(); i++)
        {
            if (players.get(i).equals(activePlayer))
            {
                if (i == (players.size() - 1))
                    activePlayer = players.get(0);
                else
                    activePlayer = players.get(i);

            }
            i++;
        }
    }

    public ArrayList createFieldList(Theme gameTheme)
    {
        list = new ArrayList<>();
        if (gameTheme == Theme.original)
        {
            list.add(new Field("Los", 0, 0, FieldState.startField));
            list.add(new Field("Bad Straße", 0, 0, FieldState.normalStreets, 60, 50, 10, 30, 90, 160, 250));
            list.add(new Field("Gemeinschaftsfeld", 0, 0, FieldState.cardFieldG));
            list.add(new Field("Turm Straße", 0, 0, FieldState.normalStreets, 60, 50, 20, 60, 180, 320, 450));
            list.add(new Field("Einkommensteuer", 0, 0, FieldState.taxField));
            list.add(new Field("Süd Bahnhof", 0, 0, FieldState.trainStation, 200, 100, 200, 300, 400));
            list.add(new Field("Chaussee Straße", 0, 0, FieldState.normalStreets, 100, 50, 30, 90, 270, 400, 550));
            list.add(new Field("Ereignisfeld", 0, 0, FieldState.cardFieldE));
            list.add(new Field("Elisen Straße", 0, 0, FieldState.normalStreets, 100, 50, 30, 90, 270, 400, 550));
            list.add(new Field("Post Straße", 0, 0, FieldState.normalStreets, 120, 50, 40, 100, 300, 450, 600));
            list.add(new Field("Gefängnis", 0, 0, FieldState.prison));
            list.add(new Field("See Straße", 0, 0, FieldState.normalStreets, 140, 100, 50, 150, 450, 625, 750));
            list.add(new Field("Elektrizitätswerk", 0, 0, FieldState.workField));
            list.add(new Field("Hafen Straße", 0, 0, FieldState.normalStreets, 140, 100, 50, 150, 450, 625, 750));
            list.add(new Field("Neue Straße", 0, 0, FieldState.normalStreets, 160, 100, 60, 180, 500, 700, 900));
            list.add(new Field("West Bahnhof", 0, 0, FieldState.trainStation, 200, 100, 200, 300, 400));
            list.add(new Field("Münchener Straße", 0, 0, FieldState.normalStreets, 180, 100, 70, 200, 550, 750, 950));
            list.add(new Field("Gemeinschaftsfeld", 0, 0, FieldState.cardFieldG));
            list.add(new Field("Wiener Straße", 0, 0, FieldState.normalStreets, 180, 100, 70, 200, 550, 750, 950));
            list.add(new Field("Berliner Straße", 0, 0, FieldState.normalStreets, 200, 100, 80, 220, 600, 800, 1000));
            list.add(new Field("Frei Parken", 0, 0, FieldState.freeParking));
            list.add(new Field("Theater Straße", 0, 0, FieldState.normalStreets, 220, 150, 90, 250, 700, 875, 1050));
            list.add(new Field("Ereignisfeld", 0, 0, FieldState.cardFieldE));
            list.add(new Field("Museums Straße", 0, 0, FieldState.normalStreets, 220, 150, 90, 250, 700, 875, 1050));
            list.add(new Field("Opernplatz", 0, 0, FieldState.normalStreets, 240, 150, 100, 300, 750, 925, 1100));
            list.add(new Field("Nord Bahnhof", 0, 0, FieldState.trainStation, 200, 100, 200, 300, 400));
            list.add(new Field("Lessing Straße", 0, 0, FieldState.normalStreets, 260, 150, 110, 330, 800, 975, 1150));
            list.add(new Field("Schiller Straße", 0, 0, FieldState.normalStreets, 260, 150, 120, 360, 850, 1025, 1200));
            list.add(new Field("Wasser Werk", 0, 0, FieldState.workField));
            list.add(new Field("Goethe Straße", 0, 0, FieldState.normalStreets, 280, 150, 110, 330, 800, 975, 1150));
            list.add(new Field("Gehe ins Gefängnis", 0, 0, FieldState.goToPrison));
            list.add(new Field("Rathaus Platz", 0, 0, FieldState.normalStreets, 300, 200, 130, 390, 900, 1100, 1275));
            list.add(new Field("Haupt Straße", 0, 0, FieldState.normalStreets, 300, 200, 130, 390, 900, 1100, 1275));
            list.add(new Field("Gemeinschaftsfeld", 0, 0, FieldState.cardFieldG));
            list.add(new Field("Bahnhof Straße", 0, 0, FieldState.normalStreets, 320, 200, 150, 450, 1000, 1200, 1400));
            list.add(new Field("Haupt Bahnhof", 0, 0, FieldState.trainStation, 200, 100, 200, 300, 400));
            list.add(new Field("Ereignisfeld", 0, 0, FieldState.cardFieldE));
            list.add(new Field("Park Straße", 0, 0, FieldState.normalStreets, 350, 200, 175, 500, 1100, 1300, 1500));
            list.add(new Field("Zusatzsteuer", 0, 0, FieldState.taxField));
            list.add(new Field("Schloss Allee", 0, 0, FieldState.normalStreets, 400, 200, 200, 600, 1400, 1700, 2000));
        } else if (gameTheme == Theme.lette)
        {
            list.add(new Field("Los", 0, 0, FieldState.startField));
            list.add(new Field("Bäcker", 0, 0, FieldState.normalStreets, 60, 50, 10, 30, 90, 160, 250));
            list.add(new Field("Gemeinschaftsfeld", 0, 0, FieldState.cardFieldG));
            list.add(new Field("Mensa", 0, 0, FieldState.normalStreets, 60, 50, 20, 60, 180, 320, 450));
            list.add(new Field("Einkommensteuer", 0, 0, FieldState.taxField));
            list.add(new Field("Südeingang", 0, 0, FieldState.trainStation, 200, 100, 200, 300, 400));
            list.add(new Field("Animationstechnik", 0, 0, FieldState.normalStreets, 100, 50, 30, 90, 270, 400, 550));
            list.add(new Field("Ereignisfeld", 0, 0, FieldState.cardFieldE));
            list.add(new Field("Sensortechnik", 0, 0, FieldState.normalStreets, 100, 50, 30, 90, 270, 400, 550));
            list.add(new Field("Digitaltechnik", 0, 0, FieldState.normalStreets, 120, 50, 40, 100, 300, 450, 600));
            list.add(new Field("Mathe", 0, 0, FieldState.prison));
            list.add(new Field("Sport", 0, 0, FieldState.normalStreets, 140, 100, 50, 150, 450, 625, 750));
            list.add(new Field("Elektrizitätsraum", 0, 0, FieldState.workField));
            list.add(new Field("Deutsch", 0, 0, FieldState.normalStreets, 140, 100, 50, 150, 450, 625, 750));
            list.add(new Field("Englisch", 0, 0, FieldState.normalStreets, 160, 100, 60, 180, 500, 700, 900));
            list.add(new Field("Westeingang", 0, 0, FieldState.trainStation, 200, 100, 200, 300, 400));
            list.add(new Field("Physik", 0, 0, FieldState.normalStreets, 180, 100, 70, 200, 550, 750, 950));
            list.add(new Field("Chemie", 0, 0, FieldState.normalStreets, 180, 100, 70, 200, 550, 750, 950));
            list.add(new Field("Gemeinschaftsfeld", 0, 0, FieldState.cardFieldG));
            list.add(new Field("Botanik", 0, 0, FieldState.normalStreets, 200, 100, 80, 220, 600, 800, 1000));
            list.add(new Field("Chillraum", 0, 0, FieldState.freeParking));
            list.add(new Field("Biochemie", 0, 0, FieldState.normalStreets, 220, 150, 90, 250, 700, 875, 1050));
            list.add(new Field("EDV", 0, 0, FieldState.normalStreets, 220, 150, 90, 250, 700, 875, 1050));
            list.add(new Field("Ereignisfeld", 0, 0, FieldState.cardFieldE));
            list.add(new Field("Anatomie", 0, 0, FieldState.normalStreets, 240, 150, 100, 300, 750, 925, 1100));
            list.add(new Field("Nordeingang", 0, 0, FieldState.trainStation, 200, 100, 200, 300, 400));
            list.add(new Field("Bildgestaltung", 0, 0, FieldState.normalStreets, 260, 150, 110, 330, 800, 975, 1150));
            list.add(new Field("Virtuelle Kultur", 0, 0, FieldState.normalStreets, 260, 150, 120, 360, 850, 1025, 1200));
            list.add(new Field("Toilette", 0, 0, FieldState.workField));
            list.add(new Field("Digitalmedien", 0, 0, FieldState.normalStreets, 280, 150, 110, 330, 800, 975, 1150));
            list.add(new Field("Herr Bode", 0, 0, FieldState.goToPrison));
            list.add(new Field("Ernährungskunde", 0, 0, FieldState.normalStreets, 300, 200, 130, 390, 900, 1100, 1275));
            list.add(new Field("Körperpflegekunde", 0, 0, FieldState.normalStreets, 320, 200, 150, 450, 1000, 1200, 1400));
            list.add(new Field("Gemeinschaftsfeld", 0, 0, FieldState.cardFieldG));
            list.add(new Field("Medizin", 0, 0, FieldState.normalStreets, 320, 200, 150, 450, 1000, 1200, 1400));
            list.add(new Field("Haupteingang", 0, 0, FieldState.trainStation, 200, 100, 200, 300, 400));
            list.add(new Field("Illustrator", 0, 0, FieldState.normalStreets, 350, 200, 175, 500, 1100, 1300, 1500));
            list.add(new Field("zusatzsteuer", 0, 0, FieldState.taxField));
            list.add(new Field("Typographie", 0, 0, FieldState.normalStreets, 400, 200, 200, 600, 1400, 1700, 2000));
        }

        return list;
    }
}
