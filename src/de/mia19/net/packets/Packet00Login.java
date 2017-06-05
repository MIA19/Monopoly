package de.mia19.net.packets;

import de.mia19.net.GameClient;
import de.mia19.net.GameServer;

public class Packet00Login extends Packet
{

    private String username;

    public Packet00Login(byte[] data)
    {
        super(00);
        String[] dataArr = readData(data).split(",");
        this.username = dataArr[0];
    }

    public Packet00Login(String username)
    {
        super(00);
        this.username = username;
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
        return ("00" + this.username).getBytes();
    }

    public String getUsername()
    {
        return username;
    }

}
