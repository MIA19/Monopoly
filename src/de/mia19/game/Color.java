package de.mia19.game;

public enum Color
{
    RED,
    BLUE,
    GREEN,
    VIOLET,
    YELLOW,
    WHITE;

    public static Color parseString(String s)
    {
        switch (s)
        {
            case "red":
                return RED;
            case "blue":
                return BLUE;
            case "green":
                return GREEN;
            case "violet":
                return VIOLET;
            case "yellow":
                return YELLOW;
            case "white":
                return WHITE;
            default:
                return null;
        }
    }
}
