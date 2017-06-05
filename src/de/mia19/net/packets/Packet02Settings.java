package de.mia19.net.packets;

import de.mia19.net.GameClient;
import de.mia19.net.GameServer;

public class Packet02Settings extends Packet
{
    private boolean free_parking;
    private boolean double_money;

    public Packet02Settings(byte[] data)
    {
        super(02);
        String[] dataArr = readData(data).split(",");
        this.free_parking = Boolean.getBoolean(dataArr[0]);
        this.double_money = Boolean.getBoolean(dataArr[1]);
    }

    public Packet02Settings(boolean free_parking, boolean double_money)
    {
        super(02);
        this.free_parking = free_parking;
        this.double_money = double_money;
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
        return ("02" + free_parking + "," + double_money).getBytes();
    }

    public boolean isFree_parking()
    {
        return free_parking;
    }

    public boolean isDouble_money()
    {
        return double_money;
    }
}
