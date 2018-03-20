package by.tc.task5.service;

import by.tc.task5.dao.XmlDAO;
import by.tc.task5.dao.XmlDAOImpl;
import by.tc.task5.entity.Planet;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

public class XmlDataServiceImpl implements XmlDataService {

    XmlDAO xmlDAO;
    String filePath;

    public XmlDataServiceImpl(String filePath) {
        xmlDAO = new XmlDAOImpl();
        this.filePath = filePath;
    }

    @Override
    public List<Planet> getPlanetsByDOMParser() throws IOException, SAXException {
        return xmlDAO.parse(filePath);
    }

}
