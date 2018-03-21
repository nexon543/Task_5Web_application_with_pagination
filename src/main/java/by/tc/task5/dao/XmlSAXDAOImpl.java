package by.tc.task5.dao;

import by.tc.task5.entity.Planet;
import by.tc.task5.util.xml.PlanetsBuilder;
import by.tc.task5.util.xml.sax.PlanetsSAXBuilder;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

public class XmlSAXDAOImpl implements XmlDAO {

    private final PlanetsBuilder planetsSAXBuilder = new PlanetsSAXBuilder();

    public XmlSAXDAOImpl() {}

    @Override
    public List<Planet> parse(String filePath) throws IOException, SAXException {
        planetsSAXBuilder.buildPlanets(filePath);
        return planetsSAXBuilder.getPlanets();
    }
}
