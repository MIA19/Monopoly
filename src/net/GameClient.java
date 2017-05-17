package net;

import game.PlayerMP;
import net.packets.Packet;
import net.packets.Packet00Login;
import net.packets.Packet01Disconnect;

import java.io.IOException;
import java.net.*;

public class GameClient extends Thread
{
    private InetAddress ipAddress;
    private DatagramSocket socket;

    public GameClient(String ipAddress)
    {
        try
        {
            this.socket = new DatagramSocket();
            this.ipAddress = InetAddress.getByName(ipAddress);
        }
        catch (SocketException | UnknownHostException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void run()
    {
        while (true)
        {
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            try
            {
                socket.receive(packet);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            this.parsePacket(packet.getData(), packet.getAddress(), packet.getPort());

            System.out.println("SERVER > " + new String(packet.getData()));
        }
    }

    private void parsePacket(byte[] data, InetAddress address, int port)
    {
        String msg = new String(data).trim();
        Packet.PacketTypes packetType = Packet.getPacketType(msg.substring(0, 2));
        Packet packet = null;
        switch (packetType)
        {
            default:
            case INVALID:
                break;
            case LOGIN:
                packet = new Packet00Login(data);
                System.out.println("[" + address.getHostAddress() + ":" + port + "] " + ((Packet00Login) packet).getUsername() + " joined.");
                PlayerMP player = new PlayerMP(((Packet00Login) packet).getUsername(), address, port);
                break;
            case DISCONNECT:
                packet = new Packet01Disconnect(data);
                System.out.println("[" + address.getHostAddress() + ":" + port + "] " + ((Packet01Disconnect) packet).getUsername() + " left.");

                break;
        }
    }

    public void sendData(byte[] data)
    {
        DatagramPacket packet = new DatagramPacket(data, data.length, ipAddress, 1333);
        try
        {
            socket.send(packet);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
