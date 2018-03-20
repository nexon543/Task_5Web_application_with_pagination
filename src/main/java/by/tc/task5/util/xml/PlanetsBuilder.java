package by.tc.task5.util.xml;

import by.tc.task5.entity.Planet;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

public interface PlanetsBuilder {
    void buildPlanets(String fileName) throws IOException, SAXException;

    List<Planet> getPlanets();
}
