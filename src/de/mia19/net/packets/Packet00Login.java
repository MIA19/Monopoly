package de.mia19.net.packets;

import de.mia19.game.GameColor;
import de.mia19.net.GameClient;
import de.mia19.net.GameServer;

public class Packet00Login extends Packet
{

    private GameColor gameColor;

    public Packet00Login(byte[] data)
    {
        super(00);
        String[] dataArr = readData(data).split(",");
        this.gameColor = GameColor.parseString(dataArr[0]);
    }

    public Packet00Login(GameColor gameColor)
    {
        super(00);
        this.gameColor = gameColor;
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
        return ("00" + this.gameColor.name().toLowerCase()).getBytes();
    }

    public GameColor getGameColor()
    {
        return gameColor;
    }
}
