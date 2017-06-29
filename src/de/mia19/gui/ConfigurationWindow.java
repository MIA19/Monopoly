package de.mia19.gui;

import de.mia19.game.Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ConfigurationWindow extends JFrame
{

    private ArrayList<ThemeButton> buttonList = new ArrayList<>();
    public ConfigurationWindow (Game game)
    {
        this.setTitle("Einstellungen");
        this.setSize(400,400);
        this.setBackground(game.theme.getFarbeHintergrund());
        this.repaint();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        final JLabel themaText = new JLabel("Thema");
        themaText.setHorizontalAlignment(SwingConstants.CENTER);
        themaText.setFont(new Font("Arial", Font.BOLD, 20));

        final JPanel themePanel = new JPanel();
        themePanel.setBackground(Game.instance.theme.getFarbeHintergrund());
        themePanel.setForeground(Game.instance.theme.getFarbeText());
        themePanel.setLayout(new GridLayout(4,1,2,2));
        themePanel.add(themaText);

        final JLabel configureText = new JLabel("Einstellungen");
        configureText.setHorizontalAlignment(SwingConstants.CENTER);
        configureText.setFont(new Font("Arial", Font.BOLD, 30));

        final JPanel configurePanel = new JPanel();
        this.add(configurePanel);
        configurePanel.setLayout(new GridLayout(2,1,2,2));
        configurePanel.setBackground(Game.instance.theme.getFarbeHintergrund());
        configurePanel.setForeground(Game.instance.theme.getFarbeText());
        configurePanel.add(configureText);
        configurePanel.add(themePanel);
        configurePanel.setBorder(BorderFactory.createBevelBorder(3));

        final ThemeButton radioOriginal = new ThemeButton("Original", Theme.original);
        radioOriginal.setHorizontalAlignment(SwingConstants.CENTER);

        final ThemeButton radioLette = new ThemeButton("Lette", Theme.lette);
        radioLette.setHorizontalAlignment(SwingConstants.CENTER);

        buttonList.add(radioOriginal);
        buttonList.add(radioLette);

        ButtonGroup themeGroup = new ButtonGroup();
        themeGroup.add(radioOriginal);
        themeGroup.add(radioLette);

        final JButton closeConfigWindow = new JButton("bestätigen");
        closeConfigWindow.addActionListener(e ->
        {
            for(ThemeButton btn : buttonList)
            {
                if(btn.isSelected())
                {
                    Game.instance.theme = btn.getTheme();
                    break;
                }

            }

            this.dispose();
            new StartScreen(game);
        });
        themePanel.add(radioOriginal);
        themePanel.add(radioLette);
        themePanel.add(closeConfigWindow);

        this.setVisible(true);
    }
}
