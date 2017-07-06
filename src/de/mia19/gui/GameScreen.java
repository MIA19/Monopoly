package de.mia19.gui;

import de.mia19.RessourceLoader;
import de.mia19.game.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameScreen extends JFrame {
    private Dice dice;
    public ArrayList<JLabel> moneyLabel = new ArrayList<>();
    public static JButton buybtn;
    public GameScreen(String theme)

    {

        // this.game = game;
        //Game.instance.createFieldList(gameTheme);
        //this.setLayout(new GridBagLayout());

        createRightSide();
        //  this.setUndecorated(true);
        this.setSize(1200, 830);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Monopoly");
        final JLabel feld = new JLabel();
        ImageIcon spielFeld;
        spielFeld = new ImageIcon(RessourceLoader.getImage(theme + ".png"));
        feld.setIcon(spielFeld);
        this.add(feld);
        this.setVisible(true);
    }

    private void createRightSide() {

// Money- und Namensfelder
        for (int i = 0; i < Game.getAlleTextFelder().size(); i++) {

            JLabel jl = new JLabel(Game.getAlleTextFelder().get(i).getText(), SwingConstants.CENTER);
            jl.setSize(96, 17);
            jl.setBackground(Color.WHITE);
            jl.setLocation(1005, 6 + (30 * i));
            jl.setOpaque(true);
            this.add(jl);

            JLabel jlm1 = new JLabel("Money", SwingConstants.CENTER);
            jlm1.setSize(65, 17);
            jlm1.setBackground(Color.WHITE);
            jlm1.setLocation(1127, 6 +(30 * i));
            jlm1.setOpaque(true);
            moneyLabel.add(jlm1);

            this.add (moneyLabel.get (i));
        }

        // Farbfelder

        JLabel jlc1 = new JLabel("Color", SwingConstants.CENTER);
        jlc1.setBackground(Color.pink);
        jlc1.setOpaque(true);
        jlc1.setSize(69, 21);
        jlc1.setLocation(825, 17);
        this.add(jlc1);

        JLabel jlc2 = new JLabel("Color",SwingConstants.CENTER);
        jlc2.setSize(69, 21);
        jlc2.setLocation(825, 45);
        jlc2.setOpaque(true);
        this.add(jlc2);

        JLabel jlc3 = new JLabel("Color", SwingConstants.CENTER);
        jlc3.setSize(69, 21);
        jlc3.setBackground(Color.WHITE);
        jlc3.setLocation(825, 73);
        jlc3.setOpaque(true);
        this.add(jlc3);

        JLabel jlc4 = new JLabel("Color", SwingConstants.CENTER);
        jlc4.setSize(69, 21);
        jlc4.setBackground(Color.WHITE);
        jlc4.setLocation(825, 101);
        jlc4.setOpaque(true);
        this.add(jlc4);

        JLabel jlc5 = new JLabel("Color", SwingConstants.CENTER);
        jlc5.setSize(69, 21);
        jlc5.setBackground(Color.WHITE);
        jlc5.setLocation(825, 129);
        jlc5.setOpaque(true);
        this.add(jlc5);

        JLabel jlc6 = new JLabel("Color", SwingConstants.CENTER);
        jlc6.setSize(69, 21);
        jlc6.setBackground(Color.WHITE);
        jlc6.setLocation(825, 157);
        jlc6.setOpaque(true);
        this.add(jlc6);

        ImageIcon card;
        // card = new ImageIcon(RessourceLoader.getImage("specimen.png"));
        JLabel cardbox = new JLabel("SPECIMEN|PLACEHOLDER", SwingConstants.CENTER);
        cardbox.setSize(226, 340);
        cardbox.setBackground(Color.RED);
        cardbox.setLocation(901, 413);
        cardbox.setOpaque(true);
        cardbox.setVisible(true);


        buybtn = new JButton("Kaufen");
        buybtn.setLocation(938, 760);
        buybtn.setSize(150, 30);
        buybtn.setOpaque(true);
        if (!cardbox.isVisible()) {
            buybtn.setEnabled(false);
        }
        /**
        JButton wuerfelbtn = new JButton("Wuerfeln");
        wuerfelbtn.setLocation(938, 340);
        wuerfelbtn.setSize(150, 30);
        wuerfelbtn.setOpaque(true);*/

        //wuerfelbtn.addActionListener(e ->


        this.add(buybtn);
        //this.add(wuerfelbtn);
        this.add(cardbox);

    }

}
