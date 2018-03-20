package by.tc.task5.dao;

import java.io.IOException;
import java.util.List;

import by.tc.task5.util.xml.PlanetsDOMBuilder;
import by.tc.task5.entity.Planet;
import org.xml.sax.SAXException;

public class XmlDAOImpl implements XmlDAO {

	private final PlanetsDOMBuilder planetsDOMBuilder=new PlanetsDOMBuilder();

	public XmlDAOImpl(){}
	@Override
	public List<Planet> saxParse(String filePath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Planet> domParse(String filePath) throws IOException, SAXException {
		planetsDOMBuilder.buildPlanets(filePath);
		return planetsDOMBuilder.getPlanets();
	}

	@Override
	public List<Planet> staxParse(String filePath) {
		// TODO Auto-generated method stub
		return null;
	}

}
