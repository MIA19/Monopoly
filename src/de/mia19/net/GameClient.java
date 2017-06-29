package de.mia19.net;

import de.mia19.game.Game;
import de.mia19.game.PlayerMP;
import de.mia19.net.packets.Packet;
import de.mia19.net.packets.Packet00Login;
import de.mia19.net.packets.Packet01Disconnect;
import de.mia19.net.packets.Packet02Settings;

import java.io.IOException;
import java.net.*;

public class GameClient extends Thread
{
    private InetAddress ipAddress;
    private int port;
    private DatagramSocket socket;
    private Game game;

    public GameClient(Game game, String ipAddress, int port)
    {
        this.game = game;
        this.port = port;
        try
        {
            this.socket = new DatagramSocket();
            this.ipAddress = InetAddress.getByName(ipAddress);
        } catch (SocketException | UnknownHostException e)
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
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            System.out.println("SERVER (" + packet.getAddress().getHostAddress() + ":" + packet.getPort() + ") > " + new String(packet.getData()));
            this.parsePacket(packet.getData(), packet.getAddress(), packet.getPort());
        }
    }

    private void parsePacket(byte[] data, InetAddress address, int port)
    {
        String msg = new String(data).trim();
        Packet.PacketTypes packetType = Packet.getPacketType(msg.substring(0, 2));
        Packet packet;
        switch (packetType)
        {
            default:
            case INVALID:
                break;
            case LOGIN:
                packet = new Packet00Login(data);
                handleLogin((Packet00Login) packet, address, port);
                break;
            case DISCONNECT:
                packet = new Packet01Disconnect(data);
                System.out.println("[" + address.getHostAddress() + ":" + port + "] " + ((Packet01Disconnect) packet).getColor() + " left.");
                break;
            case SETTINGS:
                packet = new Packet02Settings(data);
                game.DOUBLE_MONEY = ((Packet02Settings) packet).isDouble_money();
                game.FREE_PARKING = ((Packet02Settings) packet).isFree_parking();
                System.out.println("[" + address.getHostAddress() + ":" + port + "] Settings: " + ((Packet02Settings) packet).isDouble_money() + ";" + ((Packet02Settings) packet).isFree_parking());
                break;
        }
    }

    public void sendData(byte[] data)
    {
        DatagramPacket packet = new DatagramPacket(data, data.length, ipAddress, port);
        try
        {
            socket.send(packet);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void handleLogin(Packet00Login packet, InetAddress address, int port)
    {
        System.out.println("[" + address.getHostAddress() + ":" + port + "] " + packet.getColor() + " joined.");
        //TODO Add player to mia19.lette.game
        PlayerMP player = new PlayerMP(packet.getColor(), address, port);
    }

}
