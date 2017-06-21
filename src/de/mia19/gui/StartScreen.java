package de.mia19.gui;


import de.mia19.RessourceLoader;
import de.mia19.game.Game;

import javax.swing.*;
import java.awt.*;

public class StartScreen extends JFrame
{
    public static Theme theme = Theme.original;

    private Button startBtn;
    private Button configuration;
    private Button credits;

    public StartScreen(Game game)
    {
        this.setTitle("MONOPOLY" + " - " + theme.getName() + " Version");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(4, 1, 2, 2));
        this.setBackground(theme.getFarbeHintergrund());
        this.repaint();
        this.setAlwaysOnTop(true);
        this.setIconImage(RessourceLoader.getImage("icon.jpg"));
        //Text
        final JLabel launchScreen = new JLabel("MONOPOLY");
        launchScreen.setBackground(theme.getFarbeHintergrund());
        launchScreen.setOpaque(true);
        launchScreen.setFont(new Font("Arial", Font.BOLD, 30));
        launchScreen.setForeground(theme.getFarbeText());
        launchScreen.setHorizontalAlignment(SwingConstants.CENTER);
        launchScreen.setOpaque(true);

        //Startknopf
        this.startBtn = new Button("Starte Spiel", theme);
        this.startBtn.setOpaque(true);
        this.startBtn.addActionListener(e ->
        {
            game.start();
            this.dispose();
            //TODO GAME SETUP
        });

        this.configuration = new Button("Einstellungen", theme);
        this.configuration.setOpaque(true);
        this.configuration.addActionListener(e ->
        {
            new ConfigurationWindow(game);
            this.dispose();
        });

        this.credits = new Button("Credits", theme);
        this.credits.addActionListener(e -> JOptionPane.showMessageDialog(null, "Programmiert von: \n-Daniel\n-Hubert\n-Lucas\n-Noah\n-Philipp\n-Robin\n-Sandra\n-Florian", "Credits", 0, new ImageIcon(RessourceLoader.getImage("icon.jpg"))));
        this.credits.setOpaque(true);

        //Fenster hinzufügen
        this.add(launchScreen);
        this.add(startBtn);
        this.add(this.configuration);
        this.add(credits);

        this.setVisible(true);
    }

}
