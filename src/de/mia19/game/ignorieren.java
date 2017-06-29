package de.mia19.game;

import javax.swing.*;

/**
 * Created by Schueler on 28.06.2017.
 */
public class ignorieren{

    public static void main(String[] args) {

        /**
         * Die Combobox für die Anzahl der Spieler!
         */
        JLabel aussage = new JLabel("Wähle die Anzahl der Spieler!");

        Integer[] comboBoxListe = {
                1, 2, 3, 4, 5, 6};

        JComboBox spielerAuswahl = new JComboBox(comboBoxListe);
        final JComponent[] inputs = new JComponent[]{
                aussage,
                spielerAuswahl
        };

        JOptionPane.showConfirmDialog(null, inputs, "Game Settings", JOptionPane.OK_CANCEL_OPTION);
        int playerCount = (int) spielerAuswahl.getSelectedItem();
        //int playerCount = inputs;
    }
}
