package de.mia19.gui;

import de.mia19.RessourceLoader;
import de.mia19.game.Field;
import de.mia19.game.FieldState;
import de.mia19.game.Game;
import de.mia19.game.Stats;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GameScreen extends JFrame {


    private ImageIcon spielFeld;

    public GameScreen(String theme)

    {

       // this.game = game;
        //Game.instance.createFieldList(gameTheme);
        //this.setLayout(new GridBagLayout());

        createRightSide();
        this.setSize(1200, 806);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Monopoly");
        final JLabel feld = new JLabel();
        spielFeld = new ImageIcon(RessourceLoader.getImage(theme + ".jpg"));
        feld.setIcon(spielFeld);
        this.add(feld);
        this.setVisible(true);
       // final JPanel eastSide = createRightSide();
       // this.getContentPane().add(eastSide, BorderLayout.EAST);


    }



   public void createRightSide() {

       JLabel jln1 = new JLabel("Name", SwingConstants.CENTER);
       jln1.setSize(96,17);
       jln1.setBackground(Color.WHITE);
       jln1.setLocation(1005,6);
       jln1.setOpaque(true);

       JLabel jln2 = new JLabel("Name", SwingConstants.CENTER);
       jln2.setSize(96,17);
       jln2.setBackground(Color.WHITE);
       jln2.setLocation(1005,36);
       jln2.setOpaque(true);

       JLabel jln3 = new JLabel("Name", SwingConstants.CENTER);
       jln3.setSize(96,17);
       jln3.setBackground(Color.WHITE);
       jln3.setLocation(1005,63);
       jln3.setOpaque(true);

       JLabel jln4 = new JLabel("Name", SwingConstants.CENTER);
       jln4.setSize(96,17);
       jln4.setBackground(Color.WHITE);
       jln4.setLocation(1005,93);
       jln4.setOpaque(true);

       JLabel jln5 = new JLabel("Name", SwingConstants.CENTER);
       jln5.setSize(96,17);
       jln5.setBackground(Color.WHITE);
       jln5.setLocation(1005,123);
       jln5.setOpaque(true);

       JLabel jln6 = new JLabel("Name", SwingConstants.CENTER);
       jln6.setSize(96,17);
       jln6.setBackground(Color.WHITE);
       jln6.setLocation(1005,153);
       jln6.setOpaque(true);


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

       this.add(jln1);
       this.add(jln2);
       this.add(jln3);
       this.add(jln4);
       this.add(jln5);
       this.add(jln6);
       this.add(jlm1);
       this.add(jlm2);
       this.add(jlm3);
       this.add(jlm4);
       this.add(jlm5);
       this.add(jlm6);

   }

}
