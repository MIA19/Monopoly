package de.mia19.game;

public enum ColorPlayer {
    BLUE("Blue"),
    RED("Red"),
    GREEN("Green"),
    VIOLET("Violet"),
    YELLOW("Yellow"),
    WHITE("White");

    private String name;

    ColorPlayer(String s)
    {
        this.name = s;
    }

    public static ColorPlayer parseString(String s)
    {
        for(ColorPlayer c : ColorPlayer.values())
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
}
