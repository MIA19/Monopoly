package de.mia19.game;

import java.util.ArrayList;

/**
 * Created by e6_schneider on 14.06.2017.
 */
public class ECCards {


    /**
     * ausführung der Metoden geselschaftskarten() und ereigniskarten().
     */
    public ECCards() {
        gemeinschaftskarten();
        ereigniskarten();
    }

    /**
     * Erstellung einer ArrayList "deck" mit 15 verschiedenen Gemeinschaftskarten.
     */
    public ArrayList gemeinschaftskarten(){
        ArrayList<Communitycard> deck = new ArrayList<>();
//TODO pfade einfügen
        deck.add(new Communitycard(100, "Du erhälst 100.",""));
        deck.add(new Communitycard(-500, "Zahle 500.",""));
        deck.add(new Communitycard(-200, "Zahle 200.",""));
        deck.add(new Communitycard(100, "Preisgeld: 100",""));
        deck.add(new Communitycard(0, "Heute ist dein Geburtstag. Jeder Mitspieler schenkt Dir 10",""));
        deck.add(new Communitycard(-50, "Das Meer tritt über die Ufer. Es entsteht ein Schaden von 50",""));
        deck.add(new Communitycard(-200, "Gehe über `Los` und ziehe keine 200 ein.",""));
        deck.add(new Communitycard(0, "Rücke vor bis `Los`",""));
        deck.add(new Communitycard(200, "Du erhälst 200",""));
        deck.add(new Communitycard(-10, "Du spendest an die Kirche 10",""));
        deck.add(new Communitycard(0, "Freifahrtsschein(Karte kann behalten werden)",""));
        deck.add(new Communitycard(-100, "Zahle 100",""));
        deck.add(new Communitycard(30, "Du erhälst 30",""));
        deck.add(new Communitycard(50, "Du erhälst 50",""));
        deck.add(new Communitycard(-200, "Gehe in "+Field.getFieldName()+ ". Begib dich dierekt dort hin, gehe nicht über `Los` und ziehe keine 200 ein",""));
        return deck;
    }

    /**
     * Erstellung einer ArrayList deck mit 16 verschiedenen Ereigbiskarten.
     */
    public ArrayList ereigniskarten(){
        ArrayList<Eventcard> deck = new ArrayList<>();
        deck.add(new Eventcard(0, "Gehe 3 Felder zurück.",""));
        deck.add(new Eventcard(40, "Straßenausbesserungsarbeiten sind dringend nötig zahle 40.",""));
        deck.add(new Eventcard(0, "Rücke vor bis zu "+Field.getFieldName()+". Wenn du über los kommst ziehe 200 ein.",""));
        deck.add(new Eventcard(-200, "Gehe in "+Field.getFieldName()+". Gehe nicht über `Los`und ziehe keine 200 ein",""));
        deck.add(new Eventcard(0, "Freifahrtsschein(Karte kann behalten werden)",""));
        deck.add(new Eventcard(-20, "Zahle 20 Strafe.",""));
        deck.add(new Eventcard(-20, "Zahle 20.",""));
        deck.add(new Eventcard(0, "Gehe zur "+Field.getFieldName()+".",""));
        deck.add(new Eventcard(-150, "Zahle 150.",""));
        deck.add(new Eventcard(100, "Aktion bringen dir 100.",""));
        deck.add(new Eventcard(200, "Die Versicherung zahlt dir 200.",""));
        deck.add(new Eventcard(500, "Du erhällst 500.",""));
        deck.add(new Eventcard(-250, "Gebühren für nicht eingehaltene Denkmalpflege. Zahle 250.",""));
        deck.add(new Eventcard(0, "Mache einen Ausflug zum "+Field.getFieldName()+". Wenn du über `Los` kommst, ziehe 200 Gehalt ein.",""));
        deck.add(new Eventcard(0, "Gehe zur "+Field.getFieldName()+". Gehe nicht über `Los`und ziehe 200 ein",""));
        deck.add(new Eventcard(0, "Rücke vor bis `Los`.",""));
        return deck;
    }
}
