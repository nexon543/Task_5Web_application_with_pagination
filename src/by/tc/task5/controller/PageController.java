package by.tc.task5.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.tc.task5.entity.Planet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    	List<Planet> planets=new ArrayList<>();
        Planet planet=new Planet();
        planet.setDiameter(4880);
        planet.setName("Mercury");
        planet.setOrbitalPeriod(88);
        planet.setYearOfDiscovering(1631);
        req.setAttribute("planets", planets);
        int currentPage=1;
        if (req.getParameter("currentPage") != null) {
    	currentPage=Integer.parseInt(req.getParameter("currentPage"));
        }
        System.out.println("currentPage: "+currentPage);
    	int recordsN=26;
        int recordsPerPage=5;
        int pagesN=recordsN/recordsPerPage;
        if (recordsN%recordsPerPage != 0) {
        	pagesN++;
        }
        
        req.setAttribute("currentPage",	currentPage);
    	req.setAttribute("pagesQuantity", pagesN);
        req.getRequestDispatcher("jsp/tablePage.jsp").forward(req,resp);
    }
}
