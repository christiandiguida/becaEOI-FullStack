package com.chris.utilidades;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import com.chris.entidades.Noticia;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlUtils {

    public static Document readXMLs(String rutaCompleta) {
        try {
            File inputFile = new File(rutaCompleta);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            Document doc = dbBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            return doc;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        return null;

    }

    public static void leerXmlAsignaturas(String rutaCompleta) {
        Document doc = readXMLs(rutaCompleta);
        System.out.println("Elemento base: " + doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("asignatura");
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            nNode.getAttributes();
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println(eElement.getAttribute("id"));
                System.out.println(eElement.getElementsByTagName("nombre").item(0).getTextContent());
                System.out.println(eElement.getElementsByTagName("cicloFormativo").item(0).getTextContent());
                System.out.println(eElement.getElementsByTagName("curso").item(0).getTextContent());
                System.out.println(eElement.getElementsByTagName("profesor").item(0).getTextContent());
            }
        }
    }

    public static Document readWebXMLs(String urlCadena) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            URL url = new URL(urlCadena);
            Document doc = dbBuilder.parse(url.openStream());
            doc.getDocumentElement().normalize();
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void leerXMLInternetMarca(String urlCadena) {
        Document doc = readWebXMLs(urlCadena);
        NodeList nList = doc.getElementsByTagName("item");
        for (int i = 0; i < nList.getLength(); i++) {
            Element element = (Element) nList.item(i);
            if (element.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println("Noticia: " + element.getElementsByTagName("title").item(0).getTextContent());
            }
        }
    }

    public static String getInnerTextElements(Element element, String tagName, int position) {
        return element.getElementsByTagName(tagName).item(position).getTextContent();

    }

    public static void devolverXmlInternetMarca(String urlCadena) {
        List<Noticia> noticias = new ArrayList<Noticia>();
        Document doc = readWebXMLs(urlCadena);
        NodeList nodeList = doc.getElementsByTagName("item");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nNode = nodeList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nNode;
                noticias.add(new Noticia(getInnerTextElements(element, "title", 0),
                        getInnerTextElements(element, "description", 0), getInnerTextElements(element, "link", 0),
                        getInnerTextElements(element, "guid", 0)));
            }
        }
        noticias.forEach(n -> System.out.println(n + "\n"));
    }

}
