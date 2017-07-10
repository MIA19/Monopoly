package de.mia19.game;

import de.mia19.RessourceLoader;
import de.mia19.gui.CustomJLabel;
import de.mia19.gui.GameScreen;
import de.mia19.gui.Theme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Game
{

    private static final String NAME = "Monopoly";
    private static Game instance;

    public static List<Player> players;
    private static ArrayList<JTextField> alleTextFelder = new ArrayList<>();
    private Player activePlayer;
    public JButton buyButton;

    //DEFAULT VALUES

    private long START_MONEY = 400;
    public boolean FREE_PARKING;
    public boolean DOUBLE_MONEY;
    public ArrayList<Field> list;
    private Thread thread;
    public Theme theme = Theme.original;

    public static Game getInstance()
    {
        return (instance == null) ? (instance = new Game()) : instance;
    }

    private Game()
    {
        createFieldList(theme);
    }


    public synchronized void start()
    {

        thread = new Thread(NAME + "_main");
        thread.start();


        players = new ArrayList<>();
        buyButton = new JButton();
        buyButton.setEnabled(false);

        /**
         * Die Combobox für die Anzahl der Spieler!a
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
        playerFrame.setSize(500, 50 + 50 * playerCount);
        playerFrame.setLocationRelativeTo(null);
        JPanel playerPanel = new JPanel(new GridLayout(2 + playerCount, 2));
        JButton readyButton = new JButton("Starten");
        playerFrame.setIconImage(RessourceLoader.getImage("icon.jpg"));
        JLabel playerName = new JLabel("Geben Sie die Spielernamen ein!");
        playerPanel.add(playerName);
        playerPanel.add(new JLabel());
        String[] spielerNamen = {
                "Spieler 1", "Spieler 2", "Spieler 3", "Spieler 4", "Spieler 5", "Spieler 6"
        };

        JFrame characterchooser = new JFrame("");
        characterchooser.setLayout(new GridLayout(2,6));
        characterchooser.setSize(400,300);
        characterchooser.setLocationRelativeTo(null);

        CustomJLabel jl1 = new CustomJLabel("Char1");
        CustomJLabel jl2= new CustomJLabel("Char1");
        CustomJLabel jl3 = new CustomJLabel("Char1");
        CustomJLabel jl4 = new CustomJLabel("Char1");
        CustomJLabel jl5 = new CustomJLabel("Char1");
        CustomJLabel jl6 = new CustomJLabel("Char1");


        characterchooser.add(jl1);
        characterchooser.add(jl2);
        characterchooser.add(jl3);
        characterchooser.add(jl4);
        characterchooser.add(jl5);
        characterchooser.add(jl6);




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
        playerFrame.setLocationRelativeTo(null);

        characterchooser.setVisible(!true);

        readyButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                characterchooser.setVisible(true);
                playerFrame.dispose();
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
                if (theme == Theme.original)
                {
                    GameScreen gameScreen = new GameScreen("originaltheme");
                }
                else if (theme == Theme.lette){
                GameScreen gameScreen = new GameScreen("lette");
                activePlayer = players.get(0);
            }
            }
        });
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
                {
                    activePlayer = players.get(0);
                    break;
                }
                else
                {
                    activePlayer = players.get(i + 1);
                    break;
                }
            }
        }
        new Turn();
    }

    public ArrayList createFieldList(Theme gameTheme)
    {
        list = new ArrayList<>();
        if (gameTheme == Theme.original)
        {
            list.add(new Field("Los", 744, 743, FieldState.startField));
            list.add(new Field("Bad Straße", 650, 759, FieldState.normalStreetsPurple, 60, 50, 10, 30, 90, 160, 250));
            list.add(new Field("Gemeinschaftsfeld", 589, 758, FieldState.cardFieldG));
            list.add(new Field("Turm Straße", 527, 759, FieldState.normalStreetsPurple, 60, 50, 20, 60, 180, 320, 450));
            list.add(new Field("Einkommensteuer", 465, 759, FieldState.taxField));
            list.add(new Field("Süd Bahnhof", 403, 758, FieldState.trainStation, 200, 100, 200, 300, 400));
            list.add(new Field("Chaussee Straße", 341, 759, FieldState.normalStreetsBlue, 100, 50, 30, 90, 270, 400, 550));
            list.add(new Field("Ereignisfeld", 278, 758, FieldState.cardFieldE));
            list.add(new Field("Elisen Straße", 217, 759, FieldState.normalStreetsBlue, 100, 50, 30, 90, 270, 400, 550));
            list.add(new Field("Post Straße", 155, 759, FieldState.normalStreetsBlue, 120, 50, 40, 100, 300, 450, 600));
            list.add(new Field("Gefängnis", 81, 724, FieldState.prison));
            list.add(new Field("See Straße", 47, 651, FieldState.normalStreetsPink, 140, 100, 50, 150, 450, 625, 750));
            list.add(new Field("Elektrizitätswerk", 47, 589, FieldState.workField));
            list.add(new Field("Hafen Straße", 47, 527, FieldState.normalStreetsPink, 140, 100, 50, 150, 450, 625, 750));
            list.add(new Field("Neue Straße", 47, 464, FieldState.normalStreetsPink, 160, 100, 60, 180, 500, 700, 900));
            list.add(new Field("West Bahnhof", 47, 403, FieldState.trainStation, 200, 100, 200, 300, 400));
            list.add(new Field("Münchener Straße", 47, 340, FieldState.normalStreetsOrange, 180, 100, 70, 200, 550, 750, 950));
            list.add(new Field("Gemeinschaftsfeld", 47, 279, FieldState.cardFieldG));
            list.add(new Field("Wiener Straße", 47, 217, FieldState.normalStreetsOrange, 180, 100, 70, 200, 550, 750, 950));
            list.add(new Field("Berliner Straße", 47, 155, FieldState.normalStreetsOrange, 200, 100, 80, 220, 600, 800, 1000));
            list.add(new Field("Frei Parken", 61, 62, FieldState.freeParking));
            list.add(new Field("Theater Straße", 155, 47, FieldState.normalStreetsRed, 220, 150, 90, 250, 700, 875, 1050));
            list.add(new Field("Ereignisfeld", 217, 47, FieldState.cardFieldE));
            list.add(new Field("Museums Straße", 279, 47, FieldState.normalStreetsRed, 220, 150, 90, 250, 700, 875, 1050));
            list.add(new Field("Opernplatz", 341, 47, FieldState.normalStreetsRed, 240, 150, 100, 300, 750, 925, 1100));
            list.add(new Field("Nord Bahnhof", 403, 47, FieldState.trainStation, 200, 100, 200, 300, 400));
            list.add(new Field("Lessing Straße", 465, 47, FieldState.normalStreetsYellow, 260, 150, 110, 330, 800, 975, 1150));
            list.add(new Field("Schiller Straße", 527, 47, FieldState.normalStreetsYellow, 260, 150, 120, 360, 850, 1025, 1200));
            list.add(new Field("Wasser Werk", 589, 47, FieldState.workField));
            list.add(new Field("Goethe Straße", 652, 47, FieldState.normalStreetsYellow, 280, 150, 110, 330, 800, 975, 1150));
            list.add(new Field("Gehe ins Gefängnis", 725, 80, FieldState.goToPrison));
            list.add(new Field("Rathaus Platz", 749, 155, FieldState.normalStreetsGreen, 300, 200, 130, 390, 900, 1100, 1275));
            list.add(new Field("Haupt Straße", 759, 217, FieldState.normalStreetsGreen, 300, 200, 130, 390, 900, 1100, 1275));
            list.add(new Field("Gemeinschaftsfeld", 759, 278, FieldState.cardFieldG));
            list.add(new Field("Bahnhof Straße", 758, 340, FieldState.normalStreetsGreen, 320, 200, 150, 450, 1000, 1200, 1400));
            list.add(new Field("Haupt Bahnhof", 759, 402, FieldState.trainStation, 200, 100, 200, 300, 400));
            list.add(new Field("Ereignisfeld", 759, 464, FieldState.cardFieldE));
            list.add(new Field("Park Straße", 759, 526, FieldState.normalStreetsDarkBlue, 350, 200, 175, 500, 1100, 1300, 1500));
            list.add(new Field("Zusatzsteuer", 759, 588, FieldState.taxField));
            list.add(new Field("Schloss Allee", 759, 649, FieldState.normalStreetsDarkBlue, 400, 200, 200, 600, 1400, 1700, 2000));
        }
        else if (gameTheme == Theme.lette)
        {
            list.add(new Field("Los", 744, 743, FieldState.startField));
            list.add(new Field("Bäcker", 650, 759, FieldState.normalStreetsPurple, 60, 50, 10, 30, 90, 160, 250));
            list.add(new Field("Gemeinschaftsfeld", 589, 758, FieldState.cardFieldG));
            list.add(new Field("Mensa", 527, 759, FieldState.normalStreetsPurple, 60, 50, 20, 60, 180, 320, 450));
            list.add(new Field("Einkommensteuer", 465, 759, FieldState.taxField));
            list.add(new Field("Südeingang", 403, 758, FieldState.trainStation, 200, 100, 200, 300, 400));
            list.add(new Field("Animationstechnik", 341, 759, FieldState.normalStreetsBlue, 100, 50, 30, 90, 270, 400, 550));
            list.add(new Field("Ereignisfeld", 278, 758, FieldState.cardFieldE));
            list.add(new Field("Sensortechnik", 217, 759, FieldState.normalStreetsBlue, 100, 50, 30, 90, 270, 400, 550));
            list.add(new Field("Digitaltechnik", 155, 759, FieldState.normalStreetsBlue, 120, 50, 40, 100, 300, 450, 600));
            list.add(new Field("Mathe", 81, 724, FieldState.prison));
            list.add(new Field("Sport", 47, 651, FieldState.normalStreetsPink, 140, 100, 50, 150, 450, 625, 750));
            list.add(new Field("Elektrizitätsraum", 47, 589, FieldState.workField));
            list.add(new Field("Deutsch", 47, 527, FieldState.normalStreetsPink, 140, 100, 50, 150, 450, 625, 750));
            list.add(new Field("Englisch", 47, 464, FieldState.normalStreetsPink, 160, 100, 60, 180, 500, 700, 900));
            list.add(new Field("Westeingang", 47, 403, FieldState.trainStation, 200, 100, 200, 300, 400));
            list.add(new Field("Physik", 47, 340, FieldState.normalStreetsOrange, 180, 100, 70, 200, 550, 750, 950));
            list.add(new Field("Ereignisfeld", 47, 279, FieldState.cardFieldE));
            list.add(new Field("Chemie", 47, 217, FieldState.normalStreetsOrange, 180, 100, 70, 200, 550, 750, 950));
            list.add(new Field("Botanik", 61, 62, FieldState.normalStreetsOrange, 200, 100, 80, 220, 600, 800, 1000));
            list.add(new Field("Chillraum", 155, 47, FieldState.freeParking));
            list.add(new Field("Biochemie", 217, 47, FieldState.normalStreetsRed, 220, 150, 90, 250, 700, 875, 1050));
            list.add(new Field("Gemeinschaftsfeld", 47, 155, FieldState.cardFieldG));
            list.add(new Field("EDV", 279, 47, FieldState.normalStreetsRed, 220, 150, 90, 250, 700, 875, 1050));
            list.add(new Field("Ereignisfeld", 341, 47, FieldState.cardFieldE));
            list.add(new Field("Anatomie", 403, 47, FieldState.normalStreetsRed, 240, 150, 100, 300, 750, 925, 1100));
            list.add(new Field("Nordeingang", 465, 47, FieldState.trainStation, 200, 100, 200, 300, 400));
            list.add(new Field("Bildgestaltung", 527, 47, FieldState.normalStreetsYellow, 260, 150, 110, 330, 800, 975, 1150));
            list.add(new Field("Virtuelle Kultur", 589, 47, FieldState.normalStreetsYellow, 260, 150, 120, 360, 850, 1025, 1200));
            list.add(new Field("Toilette", 652, 47, FieldState.workField));
            list.add(new Field("Digitalmedien", 725, 80, FieldState.normalStreetsYellow, 280, 150, 110, 330, 800, 975, 1150));
            list.add(new Field("Herr Bode", 749, 155, FieldState.goToPrison));
            list.add(new Field("Ernährungskunde", 759, 217, FieldState.normalStreetsGreen, 300, 200, 130, 390, 900, 1100, 1275));
            list.add(new Field("Körperpflegekunde", 759, 278, FieldState.normalStreetsGreen, 320, 200, 150, 450, 1000, 1200, 1400));
            list.add(new Field("Gemeinschaftsfeld", 758, 340, FieldState.cardFieldG));
            list.add(new Field("Medizin", 759, 402, FieldState.normalStreetsGreen, 320, 200, 150, 450, 1000, 1200, 1400));
            list.add(new Field("Haupteingang", 759, 464, FieldState.trainStation, 200, 100, 200, 300, 400));
            list.add(new Field("Illustrator", 759, 526, FieldState.normalStreetsDarkBlue, 350, 200, 175, 500, 1100, 1300, 1500));
            list.add(new Field("zusatzsteuer", 759, 588, FieldState.taxField));
            list.add(new Field("Typographie", 759, 649, FieldState.normalStreetsDarkBlue, 400, 200, 200, 600, 1400, 1700, 2000));
        }

        return list;
    }

    public static List<Player> getPlayers()
    {
        return players;
    }

    public static ArrayList<JTextField> getAlleTextFelder()
    {
        return alleTextFelder;
    }

    public int getTrainstationCount(Player player)
    {
        int count = 0;
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).getFieldOwner() == player && list.get(i).getFieldState() == FieldState.trainStation)
            {
                count += 1;
            }
        }

        return count;
    }

    public ArrayList<Field> getOwnedFieldsByPlayer(Player player)
    {
        ArrayList<Field> temp = list.stream().filter(field -> field.getFieldOwner().equals(player)).collect(Collectors.toCollection(ArrayList::new));
        return temp;
    }

    public int getCountOfMaxStreetColor(FieldState fieldState)
    {
        int i = 0;
        for (Field field : list)
        {
            if (field.getFieldState().equals(fieldState))
                i++;
        }
        return i;
    }
}
