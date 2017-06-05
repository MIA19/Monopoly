import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA 2016.1.3
 * Created by Lucas.Tilsner
 * Date: 31.05.2017
 * Time: 10:34
 */
public class startScreen {

    private String kuenstler1 = " -Alpha-kevin";
    private String kuenstler2 = " -DK";
    private String kuenstler3 = " -Nyos";
    private String kuenstler4 = " -S4N1TZ";
    private String kuenstler5 = " -Tadomi";
    private String kuenstler6 = " -Taizai";
    private String kuenstler7 = " -Vitrex";
    private String kuenstler8 = " -zInvalid";
    private String c = "\n";


    private static JFrame fenster;
    private Thema theme;
    private ImageIcon icon;
    private JFrame configurationWindow;

    private Knopf startBtn;
    private Knopf configuration;
    private Knopf credits;

    public startScreen (JFrame gameScreen) {
        icon = new ImageIcon (this.getClass ().getResource ("img/icon.jpg"));
        theme = Thema.original;
        fenster = new JFrame ();
        macheTitel(theme);
        fenster.setSize (400, 400);
        fenster.setLocationRelativeTo (null);
        fenster.setResizable (false);
        fenster.setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
        fenster.setLayout (new GridLayout (4, 1, 2, 2));
        fenster.setBackground (theme.getFarbeHintergrund ());
        fenster.repaint ();
        fenster.setIconImage (icon.getImage ());
        //Text
        final JLabel launchScreen = new JLabel ("MONOPOLY");
        launchScreen.setBackground (theme.getFarbeHintergrund ());
        launchScreen.setOpaque (true);
        launchScreen.setFont (new Font ("Arial", Font.BOLD, 30));
        launchScreen.setForeground (theme.getFarbeText());
        launchScreen.setHorizontalAlignment (SwingConstants.CENTER);
        //Einstellungsfenster
        configurationWindow = new JFrame("Einstellungen");
        configurationWindow.setSize(400,400);
        configurationWindow.setBackground(theme.getFarbeHintergrund());
        configurationWindow.repaint();
        configurationWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        configurationWindow.setResizable(false);
        configurationWindow.setLocationRelativeTo(null);
        final JPanel configurePanel = new JPanel();
        configurationWindow.add(configurePanel);
        configurePanel.setLayout(new GridLayout(2,1,2,2));
        final JPanel themePanel = new JPanel();
        final JLabel configurText = new JLabel("Einstellungen");
        configurePanel.setBackground(theme.getFarbeHintergrund());
        configurText.setHorizontalAlignment(SwingConstants.CENTER);
        configurText.setFont(new Font("Arial", Font.BOLD, 30));
        configurePanel.add(configurText);
        configurePanel.add(themePanel);
        themePanel.setBackground(theme.getFarbeHintergrund());
        configurePanel.setBorder(BorderFactory.createBevelBorder(3));
        themePanel.setLayout(new GridLayout(4,1,2,2));
        final JRadioButton radioOriginal = new JRadioButton("Original", true);
        radioOriginal.setHorizontalAlignment(SwingConstants.CENTER);
        final JRadioButton radioLette = new JRadioButton("Lette", false);
        radioLette.setHorizontalAlignment(SwingConstants.CENTER);
        final JLabel themaText = new JLabel("Thema");
        themaText.setHorizontalAlignment(SwingConstants.CENTER);
        themaText.setFont(new Font("Arial", Font.BOLD, 20));
        themePanel.add(themaText);
        ButtonGroup themeGroup = new ButtonGroup();
        themeGroup.add(radioOriginal);
        themeGroup.add(radioLette);
        final JButton closeConfigWindow = new JButton("bestätigen");
        closeConfigWindow.addActionListener(e ->
        {
            if (radioOriginal.isSelected()){
                theme = Thema.original;
            }else if (radioLette.isSelected()){
                theme = Thema.lette;
            }
            //Fenster Titel richtig machen
            macheTitel(theme);
            //Fenster wieder mittig setzen
            fenster.setLocationRelativeTo(null);
            //Farbe neu raufklatschen
            launchScreen.setBackground(theme.getFarbeHintergrund());
            launchScreen.setForeground(theme.getFarbeText());
            startBtn.setBackground(theme.getFarbeKnopf());
            startBtn.setForeground(theme.getFarbeTextKnopf());
            configuration.setBackground(theme.getFarbeKnopf());
            configuration.setForeground(theme.getFarbeTextKnopf());
            credits.setBackground(theme.getFarbeKnopf());
            credits.setForeground(theme.getFarbeTextKnopf());
            configurePanel.setBackground(theme.getFarbeHintergrund());
            configurePanel.setForeground(theme.getFarbeText());
            themePanel.setBackground(theme.getFarbeHintergrund());
            themePanel.setForeground(theme.getFarbeText());

            //Fenster Wechsel
            configurationWindow.setVisible(false);
            fenster.setVisible(true);
        });
        themePanel.add(radioOriginal);
        themePanel.add(radioLette);
        themePanel.add(closeConfigWindow);

        //Startknopf
        startBtn = new Knopf ("Starte Spiel", theme);
        startBtn.addActionListener (e -> {
            gameScreen.setTitle("MONOPOLY"+" -"+theme.getName()+" Version");
            gameScreen.setVisible (true);
            fenster.setVisible (false);
            gameScreen.setLocationRelativeTo(null);
        });

        this.configuration = new Knopf ("Einstellungen", theme);
        this.configuration.addActionListener (e -> {
            configurationWindow.setVisible(true);
            configurationWindow.setLocationRelativeTo(null);
            fenster.setVisible(false);
        });
        credits = new Knopf ("Credits", theme);
        credits.addActionListener (e -> {
            JOptionPane.showMessageDialog (null, "Programmiert von:" + c + kuenstler2 + c + kuenstler3 + c + kuenstler4 + c + kuenstler5 + c + kuenstler6 + c + kuenstler7 + c + kuenstler8 +c+c+ "Hat Nichts gemacht:" + c + kuenstler1, "Credits", 0, icon);
        });

        launchScreen.setOpaque(true);
        startBtn.setOpaque(true);
        this.configuration.setOpaque(true);
        credits.setOpaque(true);

        //Fenster hinzufügen
        fenster.add (launchScreen);
        fenster.add (startBtn);
        fenster.add (this.configuration);
        fenster.add (credits);
    }

    public ImageIcon getIcon () {
        return icon;
    }

    public void setVisible (boolean b) {
        this.fenster.setVisible (b);
    }

    private static void macheTitel(Thema theme){
        fenster.setTitle("MONOPOLY"+" -"+theme.getName()+" Version");
    }
}
