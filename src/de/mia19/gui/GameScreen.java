package de.mia19.gui;

import de.mia19.RessourceLoader;
import de.mia19.game.*;

import javax.swing.*;
import java.awt.Color;
import java.util.ArrayList;

public class GameScreen extends JFrame {
    private Dice dice;
    public ArrayList<JLabel> moneyLabel = new ArrayList<>();
    public ArrayList<JLabel> colorLabel = new ArrayList<>();
    public static JButton buybtn;
    private static JButton closebtn;
    public GameScreen(String theme)

    {

        // this.game = game;
        //Game.instance.createFieldList(gameTheme);
        //this.setLayout(new GridBagLayout());

        createRightSide();
        //  this.setUndecorated(true);
        this.setSize(1200, 823);
        this.setUndecorated(false);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Monopoly");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
            jl.setLocation(950, 16 + (30 * i));
            jl.setOpaque(true);
            this.add(jl);

            JLabel jlm1 = new JLabel("Money", SwingConstants.CENTER);
            jlm1.setSize(65, 17);
            jlm1.setBackground(Color.WHITE);
            jlm1.setLocation(1100, 16 +(30 * i));
            jlm1.setOpaque(true);
            moneyLabel.add(jlm1);

            this.add (moneyLabel.get (i));


            JLabel jlc1 = new JLabel();
            jlc1.setSize(69, 21);
            if (i == 0){
                jlc1.setBackground(Color.BLUE);
            }
            else if (i == 1){
                jlc1.setBackground(Color.red);
            }
            else if (i == 2){
                jlc1.setBackground(Color.green);
            }
            else if (i == 3){
                jlc1.setBackground(Color.yellow);
            }
            else if (i == 4){
                jlc1.setBackground(Color.black);
            }
            else if (i == 5){
                jlc1.setBackground(Color.white);
            }
            jlc1.setOpaque(true);
            jlc1.setLocation(825, 16 + (30 * i));
            colorLabel.add(jlc1);

            this.add (colorLabel.get (i));

        }

        // Farbfelder
/*
        JLabel jlc1 = new JLabel("ColorPlayer", SwingConstants.CENTER);
        jlc1.setBackground(ColorPlayer.pink);
        jlc1.setOpaque(true);
        jlc1.setLocation(825, 16);
        this.add(jlc1);

        JLabel jlc2 = new JLabel("ColorPlayer",SwingConstants.CENTER);
        jlc2.setSize(69, 21);
        jlc2.setLocation(825, 44);
        jlc2.setOpaque(true);
        this.add(jlc2);

        JLabel jlc3 = new JLabel("ColorPlayer", SwingConstants.CENTER);
        jlc3.setSize(69, 21);
        jlc3.setBackground(ColorPlayer.WHITE);
        jlc3.setLocation(825, 72);
        jlc3.setOpaque(true);
        this.add(jlc3);

        JLabel jlc4 = new JLabel("ColorPlayer", SwingConstants.CENTER);
        jlc4.setSize(69, 21);
        jlc4.setBackground(ColorPlayer.WHITE);
        jlc4.setLocation(825, 100);
        jlc4.setOpaque(true);
        this.add(jlc4);

        JLabel jlc5 = new JLabel("ColorPlayer", SwingConstants.CENTER);
        jlc5.setSize(69, 21);
        jlc5.setBackground(ColorPlayer.WHITE);
        jlc5.setLocation(825, 128);
        jlc5.setOpaque(true);
        this.add(jlc5);

        JLabel jlc6 = new JLabel("ColorPlayer", SwingConstants.CENTER);
        jlc6.setSize(69, 21);
        jlc6.setBackground(ColorPlayer.WHITE);
        jlc6.setLocation(825, 156);
        jlc6.setOpaque(true);
        this.add(jlc6);
*/
        ImageIcon card;
        // card = new ImageIcon(RessourceLoader.getImage("specimen.png"));
        JLabel cardbox = new JLabel("PLACEHOLDER", SwingConstants.CENTER);
        cardbox.setSize(226, 340);
        cardbox.setBackground(Color.RED);
        cardbox.setLocation(901, 413);
        cardbox.setOpaque(true);
        cardbox.setVisible(true);

     /*   closebtn = new JButton();
        closebtn.setText("X");
        closebtn.setLocation(1160,0);
        closebtn.setSize(5,4);
        closebtn.setFont(new Font("Arial", Font.BOLD, 5));
        closebtn.setSize(closebtn.getPreferredSize());
        closebtn.setBackground(ColorPlayer.BLACK);
        ActionListener closelistener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        closebtn.addActionListener(closelistener);
        this.add(closebtn);
*/

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
