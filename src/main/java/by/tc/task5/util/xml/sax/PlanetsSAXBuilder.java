package by.tc.task5.util.xml.sax;

import by.tc.task5.entity.Planet;
import by.tc.task5.util.xml.PlanetsBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class PlanetsSAXBuilder implements PlanetsBuilder {

    private List<Planet> planets;
    private PlanetHandler handler;
    private XMLReader reader;

    public PlanetsSAXBuilder() {
        handler = new PlanetHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            planets=handler.getPlanets();
        }
        catch (SAXException ex){

        }
    }


    @Override
    public void buildPlanets(String fileName) throws IOException, SAXException {
            reader.parse(fileName);

    }

    @Override
    public List<Planet> getPlanets() {
        return planets;
    }
}
