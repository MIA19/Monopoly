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

    public static void main(String[] args) {
        increaseMoneyspent();
    }
    //attributes
    private static String ueberlos = null;
    private static String moneyspent = null;
    private static String moneyearned = null;
    private static String propertiesbought = null;
    private static String started = null;

    //Converted attributes
    private static int intueberlos;
    private static double doublemoneyspent;
    private static double doublemoneyearned;
    private static long longpropertiesbought;
    private static int intstarted;


    // Boolean to avoid overwriting
    private static boolean ueberlosexists = false;
    private static boolean moneyearnedexists = false;
    private static boolean moneyspentexists = false;
    private static boolean propertiesboughtexists = false;
    private static boolean startpressedexists = false;

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
            propertiesbought = getTextValue(propertiesbought, doc, "propertiesbought");
            if (propertiesbought !=null) {
                if (!statv.isEmpty())
                    statv.add(propertiesbought);
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
        moneyspentexists = true;
        readXML();
        doublemoneyspent = Double.parseDouble(moneyspent);

        saveToXML();
        moneyspentexists = false;
    }

    public static void increaseMoneyEearned(){
        moneyearnedexists = true;
        readXML();
        doublemoneyearned = Integer.parseInt(moneyearned);
        saveToXML();
        moneyearnedexists = false;
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
            if (startpressedexists || moneyspentexists || moneyearnedexists || propertiesboughtexists) {
                e = dom.createElement("ueberlos");
                e.appendChild(dom.createTextNode((ueberlos)));
                rootEle.appendChild(e);
            } else {
                e = dom.createElement("ueberlos");
                e.appendChild(dom.createTextNode((Integer.toString(intueberlos))));
                rootEle.appendChild(e);
            }
            //Started
            if (ueberlosexists || moneyspentexists || moneyearnedexists || propertiesboughtexists) {
                e = dom.createElement("started");
                e.appendChild(dom.createTextNode(started));
                rootEle.appendChild(e);
            } else {
                e = dom.createElement("started");
                e.appendChild(dom.createTextNode(Integer.toString(intstarted)));
                rootEle.appendChild(e);
            }
            //Moneyspent
            if(ueberlosexists || moneyearnedexists || startpressedexists || propertiesboughtexists) {
                e = dom.createElement("moneyspent");
                e.appendChild(dom.createTextNode(moneyspent));
                rootEle.appendChild(e);
            } else {
                e = dom.createElement("moneyspent");
                e.appendChild(dom.createTextNode(Double.toString(doublemoneyspent)));
                rootEle.appendChild(e);
            }
            //Money earned
            if(ueberlosexists || moneyspentexists || startpressedexists || propertiesboughtexists) {
                e = dom.createElement("moneyearned");
                e.appendChild(dom.createTextNode(moneyearned));
                rootEle.appendChild(e);
            } else {
                e = dom.createElement("moneyearned");
                e.appendChild(dom.createTextNode(Double.toString(doublemoneyearned)));
                rootEle.appendChild(e);
            }
            // Properties bought
            if(ueberlosexists || moneyearnedexists || startpressedexists || moneyspentexists) {
                e = dom.createElement("propertiesbought");
                e.appendChild(dom.createTextNode(propertiesbought));
                rootEle.appendChild(e);
            } else {
                e = dom.createElement("propertiesbought");
                e.appendChild(dom.createTextNode(Long.toString(longpropertiesbought)));
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
