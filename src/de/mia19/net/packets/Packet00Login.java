package de.mia19.net.packets;

import de.mia19.game.Color;
import de.mia19.net.GameClient;
import de.mia19.net.GameServer;

public class Packet00Login extends Packet
{

    private Color color;

    public Packet00Login(byte[] data)
    {
        super(00);
        String[] dataArr = readData(data).split(",");
        this.color = Color.parseString(dataArr[0]);
    }

    public Packet00Login(Color color)
    {
        super(00);
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
        return ("00" + this.color.name().toLowerCase()).getBytes();
    }

    public Color getColor()
    {
        return color;
    }
}
