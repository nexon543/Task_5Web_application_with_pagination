package by.tc.task5.dao;

import java.io.IOException;
import java.util.List;

import by.tc.task5.util.xml.PlanetsBuilder;
import by.tc.task5.util.xml.PlanetsDOMBuilder;
import by.tc.task5.entity.Planet;
import org.xml.sax.SAXException;

public class XmlDOMDAOImpl implements XmlDAO {

	private final PlanetsBuilder planetsDOMBuilder=new PlanetsDOMBuilder();

	public XmlDOMDAOImpl(){}

	@Override
	public List<Planet> parse(String filePath) throws IOException, SAXException {
		planetsDOMBuilder.buildPlanets(filePath);
		return planetsDOMBuilder.getPlanets();
	}

}
