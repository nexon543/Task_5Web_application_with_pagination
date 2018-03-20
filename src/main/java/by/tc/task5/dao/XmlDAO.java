package by.tc.task5.dao;

import java.io.IOException;
import java.util.List;

import by.tc.task5.entity.Planet;
import org.xml.sax.SAXException;

public interface XmlDAO {
	List <Planet> parse(String filePath) throws IOException, SAXException;
	
}
