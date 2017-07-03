package de.mia19.gui;

import de.mia19.RessourceLoader;
import de.mia19.game.Field;
import de.mia19.game.FieldState;
import de.mia19.game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

public class GameScreen extends JFrame implements ComponentListener
{
    private ImageIcon spielFeld;
    public GameScreen(String theme)

    {


        //Game.instance.createFieldList(gameTheme);


        this.isOpaque();

        this.setSize(950, 800);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Monopoly");
        final JLabel feld = new JLabel();
        spielFeld = new ImageIcon(RessourceLoader.getImage(theme + ".jpg"));
        feld.setIcon(spielFeld);
        this.add(feld);
        this.setVisible(true);
        final JPanel eastSide = createRightSide();
       // this.getContentPane().add(eastSide, BorderLayout.EAST);
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


    @Override
    public void componentResized(ComponentEvent componentEvent) {


    }

    @Override
    public void componentMoved(ComponentEvent componentEvent) {

    }

    @Override
    public void componentShown(ComponentEvent componentEvent) {

    }

    @Override
    public void componentHidden(ComponentEvent componentEvent) {

    }
}
