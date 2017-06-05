import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA 2016.1.3
 * Created by Lucas.Tilsner
 * Date: 31.05.2017
 * Time: 10:57
 */
public class Knopf extends JButton {
    public Knopf (String title, Thema theme) {
        this.setBackground (theme.getFarbeKnopf ());
        this.setText (title);
        this.setFont (new Font ("Arial", Font.BOLD, 20));
        this.setBorder (BorderFactory.createLineBorder (Color.BLACK, 2, true));
    }
}
