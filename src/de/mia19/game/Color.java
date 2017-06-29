package de.mia19.game;

public enum Color
{
    RED("Red"),
    BLUE("Blue"),
    GREEN("Green"),
    VIOLET("Violet"),
    YELLOW("Yellow"),
    WHITE("White");

    private String name;

    Color(String s)
    {
        this.name = s;
    }

    public static Color parseString(String s)
    {
        for(Color c : Color.values())
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
