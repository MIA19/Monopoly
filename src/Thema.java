import java.awt.*;

/**
 * Created with IntelliJ IDEA 2016.1.3
 * Created by Lucas.Tilsner
 * Date: 01.06.2017
 * Time: 08:09
 */
public enum Thema {
    original("Original",new Color (203, 250, 214),Color.BLACK, new Color (151, 214, 55), Color.BLACK),
    lette("Lette",new Color(228,228,228), Color.BLACK, new Color (210, 159, 1), Color.BLACK);

    private Color farbeHintergrund;
    private Color farbeText;
    private Color farbeKnopf;
    private Color farbeTextKnopf;
    private String name;

    Thema (String name, Color farbeHintergrund, Color farbeTextFarbe, Color farbeKnopf, Color farbeTextKnopf) {
        this.farbeHintergrund = farbeHintergrund;
        this.farbeText = farbeTextFarbe;
        this.farbeKnopf = farbeKnopf;
        this.farbeTextKnopf = farbeTextKnopf;
        this.name = name;
    }

    public Color getFarbeHintergrund () {
        return farbeHintergrund;
    }

    public Color getFarbeKnopf () {
        return farbeKnopf;
    }

    public Color getFarbeText()
    {
        return farbeText;
    }

    public Color getFarbeTextKnopf()
    {
        return farbeTextKnopf;
    }

    public String getName()
    {
        return name;
    }
}
