package de.mia19.net.packets;

import de.mia19.game.Color;
import de.mia19.net.GameClient;
import de.mia19.net.GameServer;

public class Packet01Disconnect extends Packet
{
    private Color color;

    public Packet01Disconnect(byte[] data)
    {
        super(01);
        this.color = Color.parseString(readData(data));
    }

    public Packet01Disconnect(Color color)
    {
        super(01);
        this.color = color;
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
        return ("01" + this.color.name().toLowerCase()).getBytes();
    }

    public Color getColor()
    {
        return color;
    }
}
