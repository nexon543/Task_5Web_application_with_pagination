package by.tc.task5.dao;

import java.io.IOException;
import java.util.List;

import by.tc.task5.dao.XmlDAO;
import by.tc.task5.dao.xml.PlanetsDOMBuilder;
import by.tc.task5.entity.Planet;
import org.xml.sax.SAXException;

public class XmlDAOImpl implements XmlDAO {

	private String filePath;
	private final PlanetsDOMBuilder planetsDOMBuilder=new PlanetsDOMBuilder();

	public XmlDAOImpl(String filePath){
		this.filePath=filePath;
	}
	@Override
	public List<Planet> saxParse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Planet> domParse() throws IOException, SAXException {
		planetsDOMBuilder.buildPlanets(filePath);
		return planetsDOMBuilder.getPlanets();
	}

	@Override
	public List<Planet> staxParse() {
		// TODO Auto-generated method stub
		return null;
	}

}
