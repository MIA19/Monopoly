package de.mia19.game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

/**
 * Created by Schueler on 28.06.2017.
 */
public class ignorieren{

    public static void main(String[] args) {

        /**
         * Die Combobox für die Anzahl der Spieler!
         */
        JFrame anzahlSpielerFrame = new JFrame();
        anzahlSpielerFrame.setTitle("Spieleranzahl");
        anzahlSpielerFrame.setSize(250,110);
        JPanel spielerAuswahlPanel = new JPanel();
        JButton spielerBestaetigenButton = new JButton("Start");

        JLabel aussage = new JLabel("Wähle die Anzahl der Spieler!");
        spielerAuswahlPanel.add(aussage);

        Integer[] comboBoxListe = {
                1, 2, 3, 4, 5, 6};


        JComboBox spielerAuswahl = new JComboBox(comboBoxListe);
        final JComponent[] inputs = new JComponent[]{
                aussage,
                spielerAuswahl
        };

        spielerAuswahlPanel.add(spielerAuswahl);
        spielerAuswahlPanel.add(spielerBestaetigenButton);

        JOptionPane.showConfirmDialog(null, inputs, "Game Settings", JOptionPane.OK_CANCEL_OPTION);

        /**
         * int playerCount gibt die Anzahl der Spieler, nachdem man auf Start gedrückt hat!
         */
        spielerBestaetigenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int playerCount = (int) spielerAuswahl.getSelectedItem();
                anzahlSpielerFrame.setVisible(false);
            }
        });
        anzahlSpielerFrame.add(spielerAuswahlPanel);
        anzahlSpielerFrame.setVisible(true);

    }
}
