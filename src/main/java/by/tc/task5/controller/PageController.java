package by.tc.task5.controller;

import by.tc.task5.dao.XmlParserType;
import by.tc.task5.entity.Planet;
import by.tc.task5.service.XmlDataService;
import by.tc.task5.service.XmlDataServiceImpl;
import org.xml.sax.SAXException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class PageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        String pathToXML = context.getRealPath("/WEB-INF/resources/planets.xml");
        XmlDataService service = new XmlDataServiceImpl(pathToXML);
        List<Planet> planets = null;

        HttpSession session = req.getSession(true);
        if ((session.getAttribute("xmlParserType") == null) || req.getParameter("xmlParserType") != null) {
            session.setAttribute("xmlParserType", req.getParameter("xmlParserType"));
        }
        try {
            XmlParserType parserType = XmlParserType.valueOf((String) session.getAttribute("xmlParserType"));
            planets = service.getPlanets(parserType);
        } catch (SAXException e) {

        }

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
        int startSublist = currentPage * recordsPerPage - recordsPerPage;
        int endSublist = startSublist + recordsPerPage > recordsN ? recordsN : startSublist + recordsPerPage;
        req.setAttribute("planets", planets.subList(startSublist, endSublist));
        req.getRequestDispatcher("jsp/tablePage.jsp").forward(req, resp);
    }
}
