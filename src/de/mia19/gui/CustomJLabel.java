package de.mia19.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Flo on 7/10/2017.
 */
public class CustomJLabel extends JLabel {

    public CustomJLabel(String text) {
        super(text, SwingConstants.CENTER);
    }

    @Override
    public Border getBorder() {
      return BorderFactory.createLineBorder(Color.BLACK);
    }
}
