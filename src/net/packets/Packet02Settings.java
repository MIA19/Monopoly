package net.packets;

import net.GameClient;
import net.GameServer;

public class Packet02Settings extends Packet
{
    private long start_money;

    public Packet02Settings(byte[] data)
    {
        super(02);
        String[] dataArr = readData(data).split(",");
        this.start_money = Integer.parseInt(dataArr[0]);
    }

    public Packet02Settings(long start_money)
    {
        super(02);
        this.start_money = start_money;
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
        return ("02" + start_money).getBytes();
    }

    public long getStart_money()
    {
        return start_money;
    }
}
