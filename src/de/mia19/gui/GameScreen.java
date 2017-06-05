package de.mia19.gui;

import de.mia19.RessourceLoader;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JFrame
{
    public GameScreen(String theme)
    {
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
}
