package by.tc.task5.service;

import by.tc.task5.dao.XmlDAO;
import by.tc.task5.dao.XmlDAOImpl;
import by.tc.task5.entity.Planet;
import by.tc.task5.util.xml.impl.dom.PlanetsDOMBuilder;
import by.tc.task5.util.xml.XmlParserType;
import by.tc.task5.util.xml.impl.sax.PlanetsSAXBuilder;
import by.tc.task5.util.xml.impl.stax.PlanetsStAXBuilder;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class XmlDataServiceImpl implements XmlDataService {

    private Map<XmlParserType, XmlDAO> xmlDAOMap;
    private String filePath;

    public XmlDataServiceImpl(String filePath) {
        xmlDAOMap = new EnumMap<>(XmlParserType.class);
        xmlDAOMap.put(XmlParserType.DOM, new XmlDAOImpl(new PlanetsDOMBuilder()));
        xmlDAOMap.put(XmlParserType.SAX, new XmlDAOImpl(new PlanetsSAXBuilder()));
        xmlDAOMap.put(XmlParserType.StAX, new XmlDAOImpl(new PlanetsStAXBuilder()));
        this.filePath = filePath;
    }

    @Override
    public List<Planet> getPlanets(XmlParserType parserType) throws IOException, SAXException {
        XmlDAO currentDAO = xmlDAOMap.get(parserType);
        return currentDAO.parse(filePath);
    }

}
