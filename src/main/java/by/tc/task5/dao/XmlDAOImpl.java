package by.tc.task5.dao;

import java.util.List;

import by.tc.task5.dao.XmlDAO;
import by.tc.task5.dao.xml.PlanetsDOMBuilder;
import by.tc.task5.entity.Planet;

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
	public List<Planet> domParse() {
		planetsDOMBuilder.buildPlanets(filePath);
		return planetsDOMBuilder.getPlanets();
	}

	@Override
	public List<Planet> staxParse() {
		// TODO Auto-generated method stub
		return null;
	}

}
