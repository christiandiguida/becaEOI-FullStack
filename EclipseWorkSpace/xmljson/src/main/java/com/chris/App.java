package com.chris;

import com.chris.entidades.Localidad;
import com.chris.entidades.Prediccion;
import com.chris.entidades.ProbPrecipitacion;
import com.chris.utilidades.XmlUtils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class App {
    // public static final String rutaCompleta =
    // "EclipseWorkSpace/xmljson/src/main/java/com/chris/ficheros/asignaturas.xml";
    // public static final String urlCadena =
    // "https://e00-marca.uecdn.es/rss/futbol/primera-division.xml";
    public static final String urlCadenaTiempo = "http://www.aemet.es/xml/municipios/localidad_03009.xml";
    public static final Document doc = XmlUtils.readWebXMLs(urlCadenaTiempo);
    public static final Localidad localidad = new Localidad();
    public static final Prediccion prediccion = new Prediccion();
    public static final ProbPrecipitacion probPrecipitacion = new ProbPrecipitacion();

    public static void main(String[] args) {
        creacionLocalidad();
        creacionProbPrecipitacion();

    }

    public static Element convertToElement(Node node) {
        Element element = (Element) node;
        return element;

    }

    public static void creacionLocalidad() {
        localidad.setNombre(doc.getElementsByTagName("nombre").item(0).getTextContent());
        localidad.setProvincia(doc.getElementsByTagName("nombre").item(0).getTextContent());
        // localidad.setPrediccion(doc.getElementsByTagName("nombre").item(0).getTextContent());

    }

    public static void creacionProbPrecipitacion() {
        NodeList nodeList = doc.getElementsByTagName("prediccion");
        Node node = nodeList.item(0);
        nodeList = node.getChildNodes();
        node = nodeList.item(0);

    }
}
