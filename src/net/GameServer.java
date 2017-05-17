package net;

import game.PlayerMP;
import net.packets.Packet;
import net.packets.Packet00Login;
import net.packets.Packet01Disconnect;

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

    public GameServer()
    {
        try
        {
            this.socket = new DatagramSocket(1333);
        }
        catch (SocketException e)
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
            System.out.println("CLIENT (" + packet.getAddress().getHostAddress() + ":" + packet.getPort() + ") > " + new String(packet.getData()));
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
                System.out.println("[" + address.getHostAddress() + ":" + port + "] " + ((Packet00Login) packet).getUsername() + " connected.");
                PlayerMP player = new PlayerMP(((Packet00Login) packet).getUsername(), address, port);
                this.addConnection(player, (Packet00Login) packet);
                break;
            case DISCONNECT:
                packet = new Packet01Disconnect(data);
                System.out.println("[" + address.getHostAddress() + ":" + port + "] " + ((Packet01Disconnect) packet).getUsername() + " disconnected.");
                this.removeConnection((Packet01Disconnect) packet);
                break;
        }
    }

    public void removeConnection(Packet01Disconnect packet)
    {
        this.connectedPlayers.remove(getPlayerMPIndex(packet.getUsername()));
        packet.writeData(this);
    }

    public PlayerMP getPlayerMP(String username)
    {
        for(PlayerMP player : this.connectedPlayers)
        {
            if(player.getUsername().equals(username))
                return player;
        }
        return null;
    }

    public int getPlayerMPIndex(String username)
    {
        int index = 0;
        for(PlayerMP player : this.connectedPlayers)
        {
            if(player.getUsername().equals(username))
                break;
            index++;
        }
        return index;
    }

    public void addConnection(PlayerMP player, Packet00Login packet)
    {
        boolean alreadyConnected = false;
        for(PlayerMP p : this.connectedPlayers)
        {
            if(player.getUsername().equalsIgnoreCase(p.getUsername()))
            {
                if(p.ipAddress == null)
                    p.ipAddress = player.ipAddress;

                if(p.port == -1)
                    p.port = player.port;

                alreadyConnected = true;
            }
            else
            {
                sendData(packet.getData(), p.ipAddress, p.port);
                packet = new Packet00Login(p.getUsername());
                sendData(packet.getData(), player.ipAddress, player.port);
            }
        }
        if(!alreadyConnected)
        {
            this.connectedPlayers.add(player);
        }
    }

    public void sendData(byte[] data, InetAddress ipAddress, int port)
    {
        DatagramPacket packet = new DatagramPacket(data, data.length, ipAddress, port);
        try
        {
            socket.send(packet);
        }
        catch (IOException e)
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
}
