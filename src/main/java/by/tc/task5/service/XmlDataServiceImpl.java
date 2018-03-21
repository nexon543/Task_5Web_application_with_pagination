package by.tc.task5.service;

import by.tc.task5.dao.XmlDAO;
import by.tc.task5.dao.XmlDOMDAOImpl;
import by.tc.task5.dao.XmlParserType;
import by.tc.task5.dao.XmlSAXDAOImpl;
import by.tc.task5.entity.Planet;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class XmlDataServiceImpl implements XmlDataService {

    private Map<XmlParserType, XmlDAO> xmlDAOMap;
    String filePath;

    public XmlDataServiceImpl(String filePath) {
        xmlDAOMap = new EnumMap<>(XmlParserType.class);
        xmlDAOMap.put(XmlParserType.DOM, new XmlDOMDAOImpl());
        xmlDAOMap.put(XmlParserType.SAX, new XmlSAXDAOImpl());
        this.filePath = filePath;
    }

    @Override
    public List<Planet> getPlanets(XmlParserType parserType) throws IOException, SAXException {
        XmlDAO currentDAO = xmlDAOMap.get(parserType);
        return currentDAO.parse(filePath);
    }

}
