package de.mia19.gui;

import java.awt.*;

public enum Theme
{
    original("Original", new Color(203, 250, 214), Color.BLACK, new Color(151, 214, 55), Color.BLACK),
    lette("Lette", new Color(228, 228, 228), Color.BLACK, new Color(210, 159, 1), Color.BLACK);

    private Color farbeHintergrund;
    private Color farbeText;
    private Color farbeKnopf;
    private Color farbeTextKnopf;
    private String name;

    Theme(String name, Color farbeHintergrund, Color farbeTextFarbe, Color farbeKnopf, Color farbeTextKnopf)
    {
        this.farbeHintergrund = farbeHintergrund;
        this.farbeText = farbeTextFarbe;
        this.farbeKnopf = farbeKnopf;
        this.farbeTextKnopf = farbeTextKnopf;
        this.name = name;
    }

    public Color getFarbeHintergrund()
    {
        return farbeHintergrund;
    }

    public Color getFarbeKnopf()
    {
        return farbeKnopf;
    }

    public Color getFarbeText()
    {
        return farbeText;
    }

    public Color getFarbeTextKnopf()
    {
        return farbeTextKnopf;
    }

    public String getName()
    {
        if (this.name != null)
        {
            return name;
        } else
        {
            return "";
        }
    }
}
