package by.tc.task5.controller;

import by.tc.task5.entity.Planet;
import by.tc.task5.service.XmlDataService;
import by.tc.task5.service.XmlDataServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        XmlDataService service=new XmlDataServiceImpl("d:\\Java\\projects\\IDEA\\Task_5_Web_application_with_pagination\\data\\planets.xml");
        List<Planet> planets=service.getPlanetsByDOMParser();

        int currentPage = 1;
        if (req.getParameter("currentPage") != null) {
            currentPage = Integer.parseInt(req.getParameter("currentPage"));
        }
        int recordsN = planets.size();
        int recordsPerPage = 5;
        int pagesN = recordsN / recordsPerPage;
        if (recordsN % recordsPerPage != 0) {
            pagesN++;
        }

        req.setAttribute("currentPage", currentPage);
        req.setAttribute("pagesQuantity", pagesN);
        int startSublist=currentPage*recordsPerPage-recordsPerPage;
        int endSublist=startSublist+recordsPerPage>recordsN?recordsN:startSublist+recordsPerPage;
        req.setAttribute("planets", planets.subList(startSublist,endSublist));
        req.getRequestDispatcher("jsp/tablePage.jsp").forward(req, resp);
    }
}