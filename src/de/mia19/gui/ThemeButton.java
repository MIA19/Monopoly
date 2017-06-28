package de.mia19.gui;

import de.mia19.game.Game;

import javax.swing.*;

public class ThemeButton extends JRadioButton
{
    private Theme theme;

    public ThemeButton(String text, Theme theme)
    {
        this.setText(text);
        this.theme = theme;
        if(Game.instance.theme == theme)
            this.setSelected(true);
    }


    public Theme getTheme()
    {
        return theme;
    }
}
