package de.mia19.game;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.*;
import org.w3c.dom.*;

public class Stats {


    private static String ueberlos = null;
    private static String moneyspent = null;
    private static String moneyearned = null;
    private static String started = null;

    private static int intstarted;
    private static int intueberlos;
    private static double doublemoneyearned;
    private static double doublemoneyspent;

    private static boolean startpressedexists = false;
    private static boolean ueberlosexists = false;
    private static boolean moneyearnedalreadyexists = false;
    private static boolean moneyspentalready = false;
    // private static int test2 = 1;

    private static ArrayList<String> statv;

    public static void readXML() {
        statv = new ArrayList<String>();
        Document dom;

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();

            dom = db.parse("stats.xml");

            Element doc = dom.getDocumentElement();

            ueberlos = getTextValue(ueberlos, doc, "ueberlos");
            if (ueberlos != null) {
                if (!statv.isEmpty())
                    statv.add(ueberlos);
            }

            started = getTextValue(started, doc, "started");
            if (started != null) {
                if (!statv.isEmpty())
                    statv.add(started);
            }

            moneyspent = getTextValue(moneyspent, doc, "moneyspent");
            if (moneyspent != null) {
                if (!statv.isEmpty())
                    statv.add(moneyspent);
            }

            moneyearned = getTextValue(moneyearned, doc, "moneyearned");
            if (moneyearned != null) {
                if (!statv.isEmpty())
                    statv.add(moneyearned);
            }


            //  System.out.println("Ueber los gezogen: " + ueberlos);
            // System.out.println("Auf Start geklickt: " + started);

        } catch (ParserConfigurationException pce) {
            System.out.println(pce.getMessage());

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getTextValue(String def, Element doc, String tag) {
        String value = def;
        NodeList nl;
        nl = doc.getElementsByTagName(tag);
        if (nl.getLength() > 0 && nl.item(0).hasChildNodes()) {
            value = nl.item(0).getFirstChild().getNodeValue();
        }
        return value;
    }

    //Increase Methods (Count user actions)

    public static void increaseStarted() {
        startpressedexists = true;
        readXML();
        intstarted = Integer.parseInt(started);
        intstarted++;
        saveToXML();
        startpressedexists = false;

    }

    public static void increaseUeberlos() {
        ueberlosexists = true;
        readXML();
        intueberlos = Integer.parseInt(ueberlos);
        intueberlos++;
        saveToXML();
        ueberlosexists = false;
    }

    public static void increaseMoneyspent(){
        moneyspentalready = true;
        readXML();
        doublemoneyspent = Double.parseDouble(moneyspent);

        saveToXML();
        moneyspentalready = false;
    }

    public static void increaseThemechanged(){
        moneyearnedalreadyexists = true;
        readXML();
        doublemoneyearned = Integer.parseInt(moneyearned);
        saveToXML();
        moneyearnedalreadyexists = false;
    }

    //Save everything
    public static void saveToXML() {
        Document dom;
        Element e = null;


        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.newDocument();
            Element rootEle = dom.createElement("stats");


            //Ueberlos
            if (startpressedexists || moneyspentalready || moneyearnedalreadyexists) {
                e = dom.createElement("ueberlos");
                e.appendChild(dom.createTextNode((ueberlos)));
                rootEle.appendChild(e);
            } else {
                e = dom.createElement("ueberlos");
                e.appendChild(dom.createTextNode((Integer.toString(intueberlos))));
                rootEle.appendChild(e);
            }
            //Started
            if (ueberlosexists || moneyspentalready || moneyearnedalreadyexists) {
                e = dom.createElement("started");
                e.appendChild(dom.createTextNode(started));
                rootEle.appendChild(e);
            } else {
                e = dom.createElement("started");
                e.appendChild(dom.createTextNode(Integer.toString(intstarted)));
                rootEle.appendChild(e);
            }
            //Credits viewed
            if(ueberlosexists || moneyearnedalreadyexists || startpressedexists) {
                e = dom.createElement("moneyspent");
                e.appendChild(dom.createTextNode(moneyspent));
                rootEle.appendChild(e);
            } else {
                e = dom.createElement("moneyspent");
                e.appendChild(dom.createTextNode(Double.toString(doublemoneyspent)));
                rootEle.appendChild(e);
            }
            if(ueberlosexists || moneyspentalready || startpressedexists) {
                e = dom.createElement("moneyearned");
                e.appendChild(dom.createTextNode("0"));
                rootEle.appendChild(e);
            }

            dom.appendChild(rootEle);

            try {
                Transformer tr = TransformerFactory.newInstance().newTransformer();
                tr.setOutputProperty(OutputKeys.INDENT, "yes");
                tr.setOutputProperty(OutputKeys.METHOD, "xml");
                tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "stats.dtd");
                tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

                tr.transform(new DOMSource(dom),
                        new StreamResult(new FileOutputStream("stats.xml")));

            } catch (TransformerException te) {
                System.out.println(te.getMessage());
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        } catch (ParserConfigurationException pce) {
            System.out.println("UsersXML: Error" + pce);
        }
    }

    public static String getStarted() {
        readXML();
       // System.out.println(started);
        return started;
    }

    public static String getUeberlos() {
        readXML();
        return ueberlos;
    }

    public static String getMoneyspent() {
        readXML();
        return moneyspent;
    }

    public static String getMoneyearned() {
        readXML();
        return moneyearned;
    }
}
