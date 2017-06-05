package de.mia19.gui;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton
{
    public Button(String title, Theme theme)
    {
        this.setBackground(theme.getFarbeKnopf());
        this.setText(title);
        this.setFont(new Font("Arial", Font.BOLD, 20));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    }
}
