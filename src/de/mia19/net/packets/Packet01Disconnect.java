package de.mia19.net.packets;

import de.mia19.game.GameColor;
import de.mia19.net.GameClient;
import de.mia19.net.GameServer;

public class Packet01Disconnect extends Packet
{
    private GameColor gameColor;

    public Packet01Disconnect(byte[] data)
    {
        super(01);
        this.gameColor = GameColor.parseString(readData(data));
    }

    public Packet01Disconnect(GameColor gameColor)
    {
        super(01);
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
        return ("01" + this.gameColor.name().toLowerCase()).getBytes();
    }

    public GameColor getGameColor()
    {
        return gameColor;
    }
}
