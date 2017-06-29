package de.mia19.net;

import de.mia19.game.Color;
import de.mia19.game.Game;
import de.mia19.game.PlayerMP;
import de.mia19.net.packets.Packet00Login;
import de.mia19.net.packets.Packet01Disconnect;
import de.mia19.net.packets.Packet;
import de.mia19.net.packets.Packet02Settings;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class GameServer extends Thread
{
    private DatagramSocket socket;
    private List<PlayerMP> connectedPlayers = new ArrayList<>();
    private Game game;

    public GameServer(Game game, int port)
    {
        this.game = game;
        try
        {
            this.socket = new DatagramSocket(port);
        } catch (SocketException e)
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
            System.out.println("CLIENT (" + packet.getAddress().getHostAddress() + ":" + packet.getPort() + ") > " + new String(packet.getData()));
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
                System.out.println("[" + address.getHostAddress() + ":" + port + "] " + ((Packet01Disconnect) packet).getColor() + " disconnected.");
                this.removeConnection((Packet01Disconnect) packet);
                break;
        }
    }

    public void addConnection(PlayerMP player, Packet00Login packet)
    {
        boolean alreadyConnected = false;
        for (PlayerMP p : this.connectedPlayers)
        {
            if (player.getColor().equals(p.getColor()))
            {
                if (p.ipAddress == null)
                    p.ipAddress = player.ipAddress;

                if (p.port == -1)
                    p.port = player.port;

                alreadyConnected = true;
            } else
            {
                sendData(packet.getData(), p.ipAddress, p.port);
                Packet00Login packet2 = new Packet00Login(p.getColor());
                sendData(packet2.getData(), player.ipAddress, player.port);
            }
        }
        if (!alreadyConnected)
        {
            this.connectedPlayers.add(player);
        }
    }

    public void removeConnection(Packet01Disconnect packet)
    {
        this.connectedPlayers.remove(getPlayerMPIndex(packet.getColor()));
        packet.writeData(this);
    }

    public PlayerMP getPlayerMP(Color color)
    {
        for (PlayerMP player : this.connectedPlayers)
        {
            if (player.getColor().equals(color))
                return player;
        }
        return null;
    }

    public int getPlayerMPIndex(Color color)
    {
        int index = 0;
        for (PlayerMP player : this.connectedPlayers)
        {
            if (player.getColor().equals(color))
                break;
            index++;
        }
        return index;
    }

    public void sendData(byte[] data, InetAddress ipAddress, int port)
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

    public void sendDataToAllClients(byte[] data)
    {
        for (PlayerMP p : connectedPlayers)
        {
            sendData(data, p.ipAddress, p.port);
        }
    }

    private void handleLogin(Packet00Login packet, InetAddress address, int port)
    {
        System.out.println("[" + address.getHostAddress() + ":" + port + "] " + packet.getColor() + " connected.");

        PlayerMP player = new PlayerMP(packet.getColor(), address, port);
        this.addConnection(player, packet);

        Packet02Settings packetSettings = new Packet02Settings(this.game.FREE_PARKING, this.game.DOUBLE_MONEY);
        sendData(packetSettings.getData(), address, port);
    }
}
