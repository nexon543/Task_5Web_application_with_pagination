package by.tc.web.dao;

import java.util.List;

import by.tc.task5.entity.Planet;

public interface XmlDAO {
	List <Planet> saxParse();
	List <Planet> domParse();
	List <Planet> staxParse();
	
}
