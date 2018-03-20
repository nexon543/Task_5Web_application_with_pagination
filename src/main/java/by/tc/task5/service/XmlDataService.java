package by.tc.task5.service;

import by.tc.task5.entity.Planet;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

public interface XmlDataService {
    List<Planet> getPlanetsByDOMParser() throws IOException, SAXException;
}
