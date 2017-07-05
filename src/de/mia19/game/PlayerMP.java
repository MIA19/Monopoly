package de.mia19.game;

import java.net.InetAddress;

/**
 * Multiplayer Spieler Klasse
 */
public class PlayerMP extends Player
{
    public InetAddress ipAddress;
    public int port;


    public PlayerMP(Color color, InetAddress ipAddress, int port)
    {
        super(color, "");
        this.ipAddress = ipAddress;
        this.port = port;
    }
}
