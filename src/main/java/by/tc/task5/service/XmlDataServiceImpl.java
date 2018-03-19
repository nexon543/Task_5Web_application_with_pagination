package by.tc.task5.service;

import by.tc.task5.dao.XmlDAO;
import by.tc.task5.dao.XmlDAOImpl;
import by.tc.task5.entity.Planet;

import java.util.List;

public class XmlDataServiceImpl implements XmlDataService{

    XmlDAO xmlDAO;

    public XmlDataServiceImpl (String filePath){
        xmlDAO=new XmlDAOImpl(filePath);
    }

    @Override
    public List<Planet> getPlanetsByDOMParser() {
        return xmlDAO.domParse();
    }

}
