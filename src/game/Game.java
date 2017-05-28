package game;

import net.GameClient;
import net.GameServer;
import net.packets.Packet00Login;

import javax.swing.*;

/**
 * Test Klasse GUI
 */
public class Game
{

    public static final String NAME = "Monopoly";
    public static Game instance;


    public JFrame frame;
    public boolean running = false;
    public Player player;
    public GameClient client;
    public GameServer server;

    //DEFAULT VALUES
    public long START_MONEY = 400;
    public boolean FREE_PARKING;
    public boolean DOUBLE_MONEY;

    public int PORT = 1330;
    private Thread thread;

    public void init()
    {
        instance = this;

        player = new PlayerMP(JOptionPane.showInputDialog("Enter Username:"), null, -1);

        Packet00Login loginPacket = new Packet00Login(player.getUsername());

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
                    new JLabel("<html>Startgeld (<i>400</i>):</html>"),
                    startMoney
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
