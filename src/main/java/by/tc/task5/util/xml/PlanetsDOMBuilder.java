package by.tc.task5.util.xml;

import by.tc.task5.entity.Planet;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlanetsDOMBuilder implements PlanetsBuilder {

    private List<Planet> planets;
    private DocumentBuilder documentBuilder;

    public PlanetsDOMBuilder() {
        planets = new ArrayList<>();
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            System.err.println("Parser configuration error: " + ex);
        }
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public void buildPlanets(String fileName) throws IOException, SAXException {
        Document doc;
        doc = documentBuilder.parse(fileName);
        Element root = doc.getDocumentElement();
        NodeList planetsList = root.getElementsByTagName("planet");
        int length = planetsList.getLength();
        for (int i = 0; i < length; i++) {
            Element planetElement = (Element) planetsList.item(i);
            if (planetElement.getNodeType() == Node.ELEMENT_NODE) {
                Planet planet = buildPlanet(planetElement);
                planets.add(planet);
            }

        }

    }

    private Planet buildPlanet(Element planetElement) {
        Planet planet = new Planet();
        String nodeValue = planetElement.getElementsByTagName("diameter").item(0).getTextContent();
        Integer diam = Integer.parseInt(nodeValue);
        planet.setDiameter(diam);
        nodeValue = planetElement.getElementsByTagName("name").item(0).getTextContent();
        planet.setName(nodeValue);
        nodeValue = planetElement.getElementsByTagName("orbitalPeriod").item(0).getTextContent();
        Integer arbPer = Integer.parseInt(nodeValue);
        planet.setOrbitalPeriod(arbPer);
        nodeValue = planetElement.getElementsByTagName("yearOfDiscovering").item(0).getTextContent();
        Integer year = Integer.parseInt(nodeValue);
        planet.setYearOfDiscovering(year);
        return planet;
    }

}
