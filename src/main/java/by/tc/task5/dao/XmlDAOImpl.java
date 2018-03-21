package by.tc.task5.dao;

import by.tc.task5.entity.Planet;
import by.tc.task5.util.xml.PlanetsBuilder;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

public class XmlDAOImpl implements XmlDAO {

    PlanetsBuilder planetsBuilder;

    public XmlDAOImpl(PlanetsBuilder planetsBuilder) {
        this.planetsBuilder = planetsBuilder;
    }

    @Override
    public List<Planet> parse(String filePath) throws IOException, SAXException {
        planetsBuilder.buildPlanets(filePath);
        return planetsBuilder.getPlanets();
    }
}
