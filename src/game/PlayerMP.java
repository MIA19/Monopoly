package game;

import java.net.InetAddress;

public class PlayerMP extends Player
{
    public InetAddress ipAddress;
    public int port;

    public PlayerMP(String username, InetAddress ipAddress, int port)
    {
        super(username);
        this.ipAddress = ipAddress;
        this.port = port;
    }
}
