package de.mia19.game;

public enum GameColor
{
    PURPLE("purple", new java.awt.Color(76, 0 ,153)),
    LIGHT_BLUE("light_blue", new java.awt.Color(127, 178, 255)),
    LIGHT_PURPLE("light_purple", java.awt.Color.PINK),
    ORANGE("orange", java.awt.Color.ORANGE),
    RED("red", java.awt.Color.RED),
    YELLOW("yellow", java.awt.Color.YELLOW),
    GREEN("green", java.awt.Color.GREEN),
    BLUE("blue", java.awt.Color.BLUE);

    private String name;
    private java.awt.Color color;

    GameColor(String s, java.awt.Color color)
    {
        this.name = s;
        this.color = color;
    }

    public static GameColor parseString(String s)
    {
        for(GameColor c : GameColor.values())
        {
            if(c.getName().equalsIgnoreCase(s))
                return c;
        }
        return null;
    }

    public String getName()
    {
        return name;
    }

    public java.awt.Color getColor()
    {
        return color;
    }
}
