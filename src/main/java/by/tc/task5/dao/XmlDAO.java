package by.tc.task5.dao;

import by.tc.task5.entity.Planet;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

public interface XmlDAO {
    List<Planet> parse(String filePath) throws IOException, SAXException;

}
