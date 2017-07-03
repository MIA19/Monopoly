package de.mia19.game;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by e6_schneider on 14.06.2017.
 */

public class ECCards
{
    private ArrayList<Communitycard> communitycards;
    private ArrayList<Eventcard> eventcards;


    public ECCards()
    {
    }

    /**
     * Erstellung einer ArrayList "deck" mit 15 verschiedenen Gemeinschaftskarten.
     */
    public void createCommunitycards()
    {
        communitycards = new ArrayList<>();
        communitycards.add(new Communitycard(100, "Du erhälst 100."));
        communitycards.add(new Communitycard(-500, "Zahle 500."));
        communitycards.add(new Communitycard(-200, "Zahle 200."));
        communitycards.add(new Communitycard(100, "Preisgeld: 100"));
        communitycards.add(new Communitycard(0, "Heute ist dein Geburtstag. Jeder Mitspieler schenkt Dir 10"));
        communitycards.add(new Communitycard(-50, "Das Meer tritt über die Ufer. Es entsteht ein Schaden von 50"));
        communitycards.add(new Communitycard(-200, "Gehe über `Los` und ziehe keine 200 ein."));
        communitycards.add(new Communitycard(0, "Rücke vor bis `Los`"));
        communitycards.add(new Communitycard(200, "Du erhälst 200"));
        communitycards.add(new Communitycard(-10, "Du spendest an die Kirche 10"));
        communitycards.add(new Communitycard(0, "Freifahrtsschein(Karte kann behalten werden)"));
        communitycards.add(new Communitycard(-100, "Zahle 100"));
        communitycards.add(new Communitycard(30, "Du erhälst 30"));
        communitycards.add(new Communitycard(50, "Du erhälst 50"));
        communitycards.add(new Communitycard(-200, "Gehe zu " + Field.getFromNumber(10).getFieldName() + ". Begib dich dierekt dort hin, gehe nicht über `Los` und ziehe keine 200 ein"));

    }

    /**
     * Erstellung einer ArrayList deck mit 16 verschiedenen Ereigbiskarten.
     */
    public void createEventcards()
    {
        eventcards= new ArrayList<>();
        eventcards.add(new Eventcard(-1,0, "Gehe 3 Felder zurück."));
        eventcards.add(new Eventcard(-1,40, "Straßenausbesserungsarbeiten sind dringend nötig zahle 40."));
        eventcards.add(new Eventcard(40,0, "Rücke vor bis zu " + Field.getFromNumber(40).getFieldName() + ". Wenn du über los kommst ziehe 200 ein."));
        eventcards.add(new Eventcard(10, -200, "Gehe in " + Field.getFromNumber(10).getFieldName() + ". Gehe nicht über `Los`und ziehe keine 200 ein"));
        eventcards.add(new Eventcard(-1, 0, "Freifahrtsschein(Karte kann behalten werden)"));
        eventcards.add(new Eventcard(-1,-20, "Zahle 20 Strafe."));
        eventcards.add(new Eventcard(-1,-20, "Zahle 20."));
        eventcards.add(new Eventcard(12, 0, "Gehe zur " + Field.getFromNumber(12).getFieldName() + "."));
        eventcards.add(new Eventcard(-1, -150, "Zahle 150."));
        eventcards.add(new Eventcard(-1, 100, "Aktion bringen dir 100."));
        eventcards.add(new Eventcard(-1, 200, "Die Versicherung zahlt dir 200."));
        eventcards.add(new Eventcard(-1, 500, "Du erhällst 500."));
        eventcards.add(new Eventcard(-1, -250, "Gebühren für nicht eingehaltene Denkmalpflege. Zahle 250."));
        eventcards.add(new Eventcard(24, 0, "Mache einen Ausflug zum " + Field.getFromNumber(24).getFieldName() + ". Wenn du über `Los` kommst, ziehe 200 Gehalt ein."));
        eventcards.add(new Eventcard(1, 0, "Gehe zur " + Field.getFromNumber(1).getFieldName() + ". Gehe nicht über `Los`und ziehe keine 200 ein"));
        eventcards.add(new Eventcard(0, 0, "Rücke vor bis `Los`."));

    }

    public ArrayList<Communitycard> getCommunitycards() {
        return communitycards;
    }

    public ArrayList<Eventcard> getEventcards() {
        return eventcards;
    }

    public void getCommunitycard(){
        Communitycard card = communitycards.get(new Random().nextInt(14));

    }

    public void getEventcard(Player player){
        Eventcard card = eventcards.get(new Random().nextInt(15));
        player.addMoney(card.getMoney());
        if(card.getPosition()!=-1){
            player.setPosition(card.getPosition());
        }
        JOptionPane.showConfirmDialog(null, card.getEvent());
    }


}
