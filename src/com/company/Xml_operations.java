package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
public class Xml_operations {

    void display_all_content(Document doc) {
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
        NodeList nodeList = doc.getElementsByTagName("CD");
// nodeList is not iterable, so we are using for loop
        for (int itr = 0; itr < nodeList.getLength(); itr++) {
            Node node = nodeList.item(itr);
            System.out.println("\nNode Name :" + node.getNodeName());
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                System.out.println("TITLE: " + eElement.getElementsByTagName("TITLE").item(0).getTextContent());
                System.out.println("ARTIST: " + eElement.getElementsByTagName("ARTIST").item(0).getTextContent());
                System.out.println("COUNTRY: " + eElement.getElementsByTagName("COUNTRY").item(0).getTextContent());
                System.out.println("COMPANY: " + eElement.getElementsByTagName("COMPANY").item(0).getTextContent());
                System.out.println("PRICE: " + eElement.getElementsByTagName("PRICE").item(0).getTextContent());
                System.out.println("YEAR: " + eElement.getElementsByTagName("YEAR").item(0).getTextContent());
            }
        }
    }

    void write(Document doc, String tittle, String artist, String price, String year, String country, String company, File myfile) throws TransformerException, FileNotFoundException {

        Element rootEle = doc.getDocumentElement();
        Element CD  =doc.createElement("CD");
        rootEle.appendChild(CD);

        Element title  =doc.createElement("TITLE");
        title.appendChild(doc.createTextNode(tittle));

        Element artist1  =doc.createElement("ARTIST");
        artist1.appendChild(doc.createTextNode(artist));

        Element company1  =doc.createElement("COMPANY");
        company1.appendChild(doc.createTextNode(company));

        Element country1  =doc.createElement("COUNTRY");
        country1.appendChild(doc.createTextNode(country));

        Element price1  =doc.createElement("PRICE");
        price1.appendChild(doc.createTextNode(price));

        Element year1  =doc.createElement("YEAR");
        year1.appendChild(doc.createTextNode(year));



        CD.appendChild(title);
        CD.appendChild(artist1);
        CD.appendChild(country1);
        CD.appendChild(company1);
        CD.appendChild(price1);
        CD.appendChild(year1);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transf = transformerFactory.newTransformer();

        transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transf.setOutputProperty(OutputKeys.INDENT, "yes");
        transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        DOMSource source = new DOMSource(doc);

        StreamResult console = new StreamResult(new File("C:\\Users\\moazm\\IdeaProjects\\trial\\src\\com\\company\\data.xml"));
        StreamResult file = new StreamResult(myfile);

        transf.transform(source, file);
    }
    Element search_by_tittle (String tittle, Document doc)
    {
        Element isexist=null;
        NodeList nodeList = doc.getElementsByTagName("CD");
        for (int itr = 0; itr < nodeList.getLength(); itr++) {
            Node node = nodeList.item(itr);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                if (tittle.equals(eElement.getElementsByTagName("TITLE").item(0).getTextContent()))
                    isexist= (Element) eElement.getElementsByTagName("TITLE").item(0);
            }
        }
        return isexist;
    }

    Element search_by_artist (String artist,Document doc)
    {
        Element isexist=null;
        NodeList nodeList = doc.getElementsByTagName("CD");
        for (int itr = 0; itr < nodeList.getLength(); itr++) {
            Node node = nodeList.item(itr);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                if (artist.equals(eElement.getElementsByTagName("ARTIST").item(0).getTextContent()))
                    isexist= (Element) eElement.getElementsByTagName("ARTIST").item(0);
            }
        }
        return isexist;
    }
}
