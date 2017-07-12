package de.mia19.net.packets;

import de.mia19.game.ColorPlayer;
import de.mia19.net.GameClient;
import de.mia19.net.GameServer;

public class Packet00Login extends Packet
{

    private ColorPlayer colorPlayer;

    public Packet00Login(byte[] data)
    {
        super(00);
        String[] dataArr = readData(data).split(",");
        this.colorPlayer = ColorPlayer.parseString(dataArr[0]);
    }

    public Packet00Login(ColorPlayer colorPlayer)
    {
        super(00);
        this.colorPlayer = colorPlayer;
    }

    @Override
    public void writeData(GameClient client)
    {
        client.sendData(getData());
    }

    @Override
    public void writeData(GameServer server)
    {
        server.sendDataToAllClients(getData());
    }

    @Override
    public byte[] getData()
    {
        return ("00" + this.colorPlayer.name().toLowerCase()).getBytes();
    }

    public ColorPlayer getColorPlayer()
    {
        return colorPlayer;
    }
}
