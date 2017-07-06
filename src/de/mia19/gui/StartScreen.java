package de.mia19.gui;


import de.mia19.RessourceLoader;
import de.mia19.game.Game;
import de.mia19.game.Stats;

import javax.swing.*;
import java.awt.*;

public class StartScreen extends JFrame
{
    private Button startBtn;
    private Button configuration;
    private Button credits;
    private Button stats;

    public StartScreen(Game game)
    {

        this.setTitle("MONOPOLY - " + Game.getInstance().theme.getName() + " Version");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(5, 1, 2, 2));
        this.setBackground(game.theme.getFarbeHintergrund());
        this.repaint();
        //this.setAlwaysOnTop(true);
        this.setIconImage(RessourceLoader.getImage("icon.jpg"));
        //Text
        final JLabel launchScreen = new JLabel("MONOPOLY");
        launchScreen.setBackground(game.theme.getFarbeHintergrund());
        launchScreen.setOpaque(true);
        launchScreen.setFont(new Font("Arial", Font.BOLD, 30));
        launchScreen.setForeground(game.theme.getFarbeText());
        launchScreen.setHorizontalAlignment(SwingConstants.CENTER);
        launchScreen.setOpaque(true);

        //Startknopf
        this.startBtn = new Button("Starte Spiel", game.theme);
        this.startBtn.setOpaque(true);
        this.startBtn.addActionListener(e ->
        {
            game.start();
            this.dispose();
            //TODO GAME SETUP
        });

        this.configuration = new Button("Einstellungen", game.theme);
        this.configuration.setOpaque(true);
        this.configuration.addActionListener(e ->
        {
            new ConfigurationWindow(game);
            this.dispose();
        });

        this.credits = new Button("Credits", game.theme);
        this.credits.addActionListener(e -> JOptionPane.showMessageDialog(this, "Programmiert von: \n- Hubert\n- Lucas\n- Philipp\n- Robin\n- Sandra\n- Flo\n\n\nDesigned von: \n- Daniel\n- Noah", "Credits", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(RessourceLoader.getImage("icon.jpg"))));
        this.credits.setOpaque(true);

        this.stats = new Button("Stats", game.theme);
      this.stats.addActionListener(e -> JOptionPane.showMessageDialog(this, "Stats: \nSpiel gestartet: "+Stats.getStarted()+" x\nUeber Los gezogen: "+Stats.getUeberlos()+" x\nAusgegebenes Geld: " + Stats.getMoneyspent() + " $\n", "Stats", JOptionPane.INFORMATION_MESSAGE));
        this.stats.setOpaque(true);

        //Fenster hinzufügen
        this.add(launchScreen);
        this.add(startBtn);
        this.add(this.configuration);
        this.add(credits);
        this.add(stats);

        this.setVisible(true);
    }

}
