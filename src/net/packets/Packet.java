package net.packets;

import net.GameClient;
import net.GameServer;

public abstract class Packet
{
    public enum PacketTypes
    {
        INVALID(-1), LOGIN(00), DISCONNECT(01);

        private int packetId;

        PacketTypes(int packetId)
        {
            this.packetId = packetId;
        }

        public int getId()
        {
            return packetId;
        }
    }

    public byte packetId;

    public Packet(int packetId)
    {
        this.packetId = (byte) packetId;
    }

    public abstract void writeData(GameClient client);

    public abstract void writeData(GameServer server);

    public abstract byte[] getData();

    public String readData(byte[] data)
    {
        String msg = new String(data).trim();
        return msg.substring(2);
    }

    public static PacketTypes getPacketType(String id)
    {
        try
        {
            return getPacketType((Integer.parseInt(id)));
        }
        catch (NumberFormatException e)
        {
            return PacketTypes.INVALID;
        }
    }

    public static PacketTypes getPacketType(int id)
    {
        for (PacketTypes p : PacketTypes.values())
        {
            if (p.getId() == id)
                return p;
        }
        return PacketTypes.INVALID;
    }
}
