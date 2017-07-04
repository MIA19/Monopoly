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
       // readXML();
        //increaseStartgeklickt();
        //saveToXML();


    }

    private static String ueberlos = null;
    private static int start;
    private static int intstartgeklickt;
    private static String startgeklickt = null;
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


            startgeklickt = getTextValue(startgeklickt, doc, "startgeklickt");
            if (startgeklickt != null) {
                if (!statv.isEmpty())
                    statv.add(startgeklickt);
            }

          //  System.out.println("Ueber los gezogen: " + ueberlos);
           // System.out.println("Auf Start geklickt: " + startgeklickt);

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

    public static void increaseStartgeklickt() {
        readXML();
        start = Integer.parseInt(startgeklickt);
        intstartgeklickt = start;
        intstartgeklickt++;

        saveToXML();
    }

    public static void saveToXML() {
        Document dom;
        Element e = null;


        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.newDocument();
            Element rootEle = dom.createElement("stats");


            //intueberlos = Integer.parseInt(ueberlos);


            e = dom.createElement("ueberlos");
            e.appendChild(dom.createTextNode("0"));
            rootEle.appendChild(e);

            e = dom.createElement("startgeklickt");
            e.appendChild(dom.createTextNode(Integer.toString(intstartgeklickt)));
            rootEle.appendChild(e);

            // System.out.println(resultend);
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

    public static String getStart(){
        readXML();
        //System.out.println(startgeklickt);
        return startgeklickt;

    }
}
