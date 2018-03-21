package by.tc.task5.util.xml;

import by.tc.task5.entity.Planet;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class PlanetHandler extends DefaultHandler {
    private List<Planet> planets;
    private Planet currentPlanet;
    private PlanetEnum currentEnum;
    private EnumSet<PlanetEnum> fields;

    public PlanetHandler() {
        planets = new ArrayList<>();
        fields = EnumSet.range(PlanetEnum.DIAMETER, PlanetEnum.YEAROFDISCOVERING);
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("planet".equals(localName)) {
            currentPlanet = new Planet();
        } else {
            PlanetEnum temp = PlanetEnum.valueOf(localName.toUpperCase());
            if (fields.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("planet".equals(localName)){
            planets.add(currentPlanet);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch, start, length);
        if (currentEnum != null) {
            switch (currentEnum) {
                case DIAMETER:
                    currentPlanet.setDiameter(Integer.parseInt(s));
                    break;
                case NAME:
                    currentPlanet.setName(s);
                    break;
                case YEAROFDISCOVERING:
                    currentPlanet.setYearOfDiscovering(Integer.parseInt(s));
                    break;
                case ORBITALPERIOD:
                    currentPlanet.setOrbitalPeriod(Integer.parseInt(s));
                    break;
                default:
                    throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(), currentEnum.name());
            }
            currentEnum = null;
        }
    }
}
