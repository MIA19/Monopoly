package de.mia19.game;

import java.net.InetAddress;

/**
 * Multiplayer Spieler Klasse
 */
public class PlayerMP extends Player
{
    public InetAddress ipAddress;
    public int port;


    public PlayerMP(ColorPlayer colorPlayer, InetAddress ipAddress, int port)
    {
        super(colorPlayer, "");
        this.ipAddress = ipAddress;
        this.port = port;
    }
}
