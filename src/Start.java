import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA 2016.1.3
 * Created by Lucas.Tilsner
 * Date: 17.05.2017
 * Time: 10:35
 */
public class Start {

    private static int startMoney;
    private static int playerCount;

    private static Window fenster;

    private static ArrayList<Spieler> liste = new ArrayList<>();
    public static void main(String[] args)
    {
        fenster = new Window("original");
        final startScreen startScreen = new startScreen (fenster);
        fenster.setIconImage (startScreen.getIcon ().getImage ());
        startScreen.setVisible(true);
    }
}
