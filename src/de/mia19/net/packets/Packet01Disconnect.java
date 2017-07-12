package de.mia19.net.packets;

import de.mia19.game.ColorPlayer;
import de.mia19.net.GameClient;
import de.mia19.net.GameServer;

public class Packet01Disconnect extends Packet
{
    private ColorPlayer colorPlayer;

    public Packet01Disconnect(byte[] data)
    {
        super(01);
        this.colorPlayer = ColorPlayer.parseString(readData(data));
    }

    public Packet01Disconnect(ColorPlayer colorPlayer)
    {
        super(01);
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
        return ("01" + this.colorPlayer.name().toLowerCase()).getBytes();
    }

    public ColorPlayer getColorPlayer()
    {
        return colorPlayer;
    }
}
