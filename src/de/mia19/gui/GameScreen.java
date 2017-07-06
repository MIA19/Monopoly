package de.mia19.gui;

import de.mia19.RessourceLoader;
import de.mia19.game.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionListener;

public class GameScreen extends JFrame {
    private Dice dice;

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


        if(!Game.getAlleTextFelder().isEmpty()){


       JLabel jln1 = new JLabel(Game.getAlleTextFelder().get(0).getText(), SwingConstants.CENTER);
       jln1.setSize(96,17);
       jln1.setBackground(Color.WHITE);
       jln1.setLocation(1005,6);
       jln1.setOpaque(true);
            this.add(jln1);

       JLabel jln2 = new JLabel(Game.getAlleTextFelder().get(1).getText(), SwingConstants.CENTER);
       jln2.setSize(96,17);
       jln2.setBackground(Color.WHITE);
       jln2.setLocation(1005,36);
       jln2.setOpaque(true);
            this.add(jln2);

       JLabel jln3 = new JLabel(Game.getAlleTextFelder().get(2).getText(), SwingConstants.CENTER);
       jln3.setSize(96,17);
       jln3.setBackground(Color.WHITE);
       jln3.setLocation(1005,63);
       jln3.setOpaque(true);
            this.add(jln3);

       JLabel jln4 = new JLabel(Game.getAlleTextFelder().get(3).getText(), SwingConstants.CENTER);
       jln4.setSize(96,17);
       jln4.setBackground(Color.WHITE);
       jln4.setLocation(1005,93);
       jln4.setOpaque(true);
            this.add(jln4);

       JLabel jln5 = new JLabel(Game.getAlleTextFelder().get(4).getText(), SwingConstants.CENTER);
       jln5.setSize(96,17);
       jln5.setBackground(Color.WHITE);
       jln5.setLocation(1005,123);
       jln5.setOpaque(true);
            this.add(jln5);

       JLabel jln6 = new JLabel(Game.getAlleTextFelder().get(5).getText(), SwingConstants.CENTER);
       jln6.setSize(96,17);
       jln6.setBackground(Color.WHITE);
       jln6.setLocation(1005,153);
       jln6.setOpaque(true);
            this.add(jln6);

        }


       JLabel jlm1 = new JLabel("Money", SwingConstants.CENTER);
       jlm1.setSize(65,17);
       jlm1.setBackground(Color.WHITE);
       jlm1.setLocation(1127,6);
       jlm1.setOpaque(true);

       JLabel jlm2 = new JLabel("Money", SwingConstants.CENTER);
       jlm2.setSize(65,17);
       jlm2.setBackground(Color.WHITE);
       jlm2.setLocation(1127,36);
       jlm2.setOpaque(true);

       JLabel jlm3 = new JLabel("Money", SwingConstants.CENTER);
       jlm3.setSize(65,17);
       jlm3.setBackground(Color.WHITE);
       jlm3.setLocation(1127,63);
       jlm3.setOpaque(true);

       JLabel jlm4 = new JLabel("Money", SwingConstants.CENTER);
       jlm4.setSize(65,17);
       jlm4.setBackground(Color.WHITE);
       jlm4.setLocation(1127,93);
       jlm4.setOpaque(true);

       JLabel jlm5 = new JLabel("Money", SwingConstants.CENTER);
       jlm5.setSize(65,17);
       jlm5.setBackground(Color.WHITE);
       jlm5.setLocation(1127,123);
       jlm5.setOpaque(true);

       JLabel jlm6 = new JLabel("", SwingConstants.CENTER);
       jlm6.setSize(65,17);
       jlm6.setBackground(Color.WHITE);
       jlm6.setLocation(1127,153);
       jlm6.setOpaque(true);

       ImageIcon card;
      // card = new ImageIcon(RessourceLoader.getImage("specimen.png"));
       JLabel cardbox = new JLabel("SPECIMEN|PLACEHOLDER", SwingConstants.CENTER);
       cardbox.setSize(226,340);
       cardbox.setBackground(Color.RED);
       cardbox.setLocation(901,413);
       cardbox.setOpaque(true);
       cardbox.setVisible(true);


       JButton buybtn = new JButton("Kaufen");
       buybtn.setLocation(938,780);
       buybtn.setSize(150,30);
       buybtn.setOpaque(true);
       if(!cardbox.isVisible()){
           buybtn.setEnabled(false);
       }
       JButton wuerfelbtn = new JButton("Wuerfeln");
       wuerfelbtn.setLocation(938,340);
       wuerfelbtn.setSize(150,30);
       wuerfelbtn.setOpaque(true);

       //wuerfelbtn.addActionListener(e ->

       this.add(jlm1);
       this.add(jlm2);
       this.add(jlm3);
       this.add(jlm4);
       this.add(jlm5);
       this.add(jlm6);
       this.add(buybtn);
       this.add(wuerfelbtn);
       this.add(cardbox);

   }

}
