package de.mia19.gui;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * Created with IntelliJ IDEA 2016.1.3
 * Created by Lucas.Tilsner
 * Date: 06.07.2017
 * Time: 08:56
 */
public class PlayerSymbol extends Ellipse2D {

    private int xPostion;
    private int yPostion;
    private Color color;

    public PlayerSymbol (int xPostion, int yPostion, Color color) {
        this.xPostion = xPostion;
        this.yPostion = yPostion;
        this.color = color;
    }

    public void movePlayer(int xPostion, int yPostion)
    {
        this.xPostion = xPostion;
        this.yPostion = yPostion;
    }

    public Color getColor () {
        return color;
    }

    @Override
    public double getX () {
        return xPostion;
    }

    @Override
    public double getY () {
        return yPostion;
    }

    @Override
    public double getWidth () {
        return 0;
    }

    @Override
    public double getHeight () {
        return 0;
    }

    @Override
    public boolean isEmpty () {
        return false;
    }

    @Override
    public void setFrame (double x, double y, double w, double h) {

    }

    @Override
    public Rectangle2D getBounds2D () {
        return null;
    }
}
