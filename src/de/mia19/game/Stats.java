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
    private static String themechanged = null;
    private static String started = null;

    private static int intstarted;
    private static int intueberlos;
    private static int intthemechanged;
    private static int intmoneyspent;

    private static boolean startalreadypressed = false;
    private static boolean ueberlosalready = false;
    private static boolean themealready = false;
    private static boolean creditsalreadyviewed = false;
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

            themechanged = getTextValue(themechanged, doc, "themechanged");
            if (themechanged != null) {
                if (!statv.isEmpty())
                    statv.add(themechanged);
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
        startalreadypressed = true;
        readXML();
        intstarted = Integer.parseInt(started);
        intstarted++;
        saveToXML();
        startalreadypressed = false;

    }

    public static void increaseUeberlos() {
        ueberlosalready = true;
        readXML();
        intueberlos = Integer.parseInt(ueberlos);
        intueberlos++;
        saveToXML();
        ueberlosalready = false;
    }

    public static void increaseCreditsviewed(){
        creditsalreadyviewed = true;
        readXML();
        intmoneyspent = Integer.parseInt(moneyspent);
        intmoneyspent++;
        saveToXML();
        creditsalreadyviewed = false;
    }

    public static void increaseThemechanged(){
        themealready = true;
        readXML();
        intthemechanged = Integer.parseInt(themechanged);
        saveToXML();
        themealready = false;
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
            if (startalreadypressed || creditsalreadyviewed || themealready) {
                e = dom.createElement("ueberlos");
                e.appendChild(dom.createTextNode((ueberlos)));
                rootEle.appendChild(e);
            } else {
                e = dom.createElement("ueberlos");
                e.appendChild(dom.createTextNode((Integer.toString(intueberlos))));
                rootEle.appendChild(e);
            }
            //Started
            if (ueberlosalready || creditsalreadyviewed || themealready) {
                e = dom.createElement("started");
                e.appendChild(dom.createTextNode(started));
                rootEle.appendChild(e);
            } else {
                e = dom.createElement("started");
                e.appendChild(dom.createTextNode(Integer.toString(intstarted)));
                rootEle.appendChild(e);
            }
            //Credits viewed
            if(ueberlosalready || themealready || startalreadypressed) {
                e = dom.createElement("moneyspent");
                e.appendChild(dom.createTextNode(moneyspent));
                rootEle.appendChild(e);
            } else {
                e = dom.createElement("moneyspent");
                e.appendChild(dom.createTextNode(Integer.toString(intmoneyspent)));
                rootEle.appendChild(e);
            }
            if(ueberlosalready || creditsalreadyviewed || startalreadypressed) {
                e = dom.createElement("themechanged");
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
        System.out.println(started);
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

    public static String getThemechanged() {
        readXML();
        return themechanged;
    }
}
