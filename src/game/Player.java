package game;

/**
 * Spieler Klasse
 */
public class Player
{
    private String username;
    private long money;

    public Player(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return username;
    }

    public long getMoney()
    {
        return money;
    }

    public void setMoney(long money)
    {
        this.money = money;
    }

    public void addMoney(long money)
    {
        this.money += money;
    }

    public void removeMoney(long money)
    {
        this.money -= money;
    }
}
