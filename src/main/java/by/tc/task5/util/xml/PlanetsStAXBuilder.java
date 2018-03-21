package by.tc.task5.util.xml;

import by.tc.task5.entity.Planet;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

public class PlanetsStAXBuilder implements PlanetsBuilder{

    @Override
    public void buildPlanets(String fileName) throws IOException, SAXException {

    }

    @Override
    public List<Planet> getPlanets() {
        return null;
    }
}
