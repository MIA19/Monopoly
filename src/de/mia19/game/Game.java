package de.mia19.game;

import de.mia19.net.GameClient;
import de.mia19.net.GameServer;
import de.mia19.net.packets.Packet00Login;

import javax.swing.*;

/**
 * Test Klasse GUI
 */
public class Game
{

    private static final String NAME = "Monopoly";
    private static Game instance;


    private JFrame frame;
    private boolean running = false;
    private Player player;
    private GameClient client;
    private GameServer server;

    //DEFAULT VALUES
    private long START_MONEY = 400;
    public boolean FREE_PARKING;
    public boolean DOUBLE_MONEY;

    private int PORT = 1330;
    private Thread thread;

    private void init()
    {
        instance = this;

        //TODO Player color automatisch zuweisen
        player = new PlayerMP(Color.RED, null, -1);

        Packet00Login loginPacket = new Packet00Login(player.getColor());

        if (server != null)
            server.addConnection((PlayerMP) player, loginPacket);

        loginPacket.writeData(client);

        //SETTING GAME SETTINGS
        player.setMoney(START_MONEY);
    }

    public synchronized void start()
    {
        running = true;

        thread = new Thread(NAME + "_main");
        thread.start();

        if (JOptionPane.showConfirmDialog(null, "Spiel hosten?") == JOptionPane.YES_OPTION)
        {
            JTextField port = new JTextField();
            JTextField startMoney = new JTextField();
            final JComponent[] inputs = new JComponent[]{
                    new JLabel("<html>Port (<i>1330</i>):</html>"),
                    port,
                    //new JLabel("<html>Startgeld (<i>400</i>):</html>"),
                    //startMoney
            };

            int result = JOptionPane.showConfirmDialog(null, inputs, "Spieleinstellungen", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.YES_OPTION)
            {
                if (!port.getText().isEmpty())
                    this.PORT = Integer.parseInt(port.getText());
                else if (!startMoney.getText().isEmpty())
                    this.START_MONEY = Long.parseLong(startMoney.getText());

                System.out.println("Port" + this.PORT);
                server = new GameServer(this, this.PORT);
                server.start();

                client = new GameClient(this, "localhost", this.PORT);
                client.start();
            }
            else
            {
                System.exit(0);
            }
        }
        else
        {
            String port = JOptionPane.showInputDialog("Port");
            client = new GameClient(this, "localhost", Integer.parseInt(port));
            client.start();
        }

        init();
    }

    public synchronized void stop()
    {
        running = false;

        try
        {
            thread.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
