package by.tc.task5.controller;

import by.tc.task5.util.xml.XmlParserType;
import by.tc.task5.entity.Planet;
import by.tc.task5.service.XmlDataService;
import by.tc.task5.service.XmlDataServiceImpl;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PageController extends HttpServlet {

    private static Logger logger = Logger.getLogger(PageController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(Constants.FILE_NAME).getFile());
        String pathToXML=file.getAbsolutePath();
        XmlDataService service = new XmlDataServiceImpl(pathToXML);
        List<Planet> planets = null;
        HttpSession session = req.getSession(true);
        if ((session.getAttribute(Constants.PARSER_TYPE_ATTRIBUTE_NAME) == null) || req.getParameter(Constants.PARSER_TYPE_ATTRIBUTE_NAME) != null) {
            session.setAttribute(Constants.PARSER_TYPE_ATTRIBUTE_NAME, req.getParameter(Constants.PARSER_TYPE_ATTRIBUTE_NAME));
        }
        try {
            XmlParserType parserType = XmlParserType.valueOf((String) session.getAttribute(Constants.PARSER_TYPE_ATTRIBUTE_NAME));
            planets = service.getPlanets(parserType);
        } catch (SAXException e) {
           logger.fatal(e.getMessage());
        }

        int currentPage = 1;
        if (req.getParameter(Constants.CURRENT_PAGE_ATTRIBUTE_NAME) != null) {
            currentPage = Integer.parseInt(req.getParameter(Constants.CURRENT_PAGE_ATTRIBUTE_NAME));
        }

        int recordsN = planets.size();
        int recordsPerPage = 5;
        int pagesN = recordsN / recordsPerPage;
        if (recordsN % recordsPerPage != 0) {
            pagesN++;
        }

        req.setAttribute(Constants.CURRENT_PAGE_ATTRIBUTE_NAME, currentPage);
        req.setAttribute(Constants.PAGE_QUANTITY_ATTRIBUTE_NAME, pagesN);
        int startSublist = currentPage * recordsPerPage - recordsPerPage;
        int endSublist = startSublist + recordsPerPage > recordsN ? recordsN : startSublist + recordsPerPage;
        req.setAttribute(Constants.PLANETS_LIST_ATTR_NAME, planets.subList(startSublist, endSublist));
        req.getRequestDispatcher("jsp/tablePage.jsp").forward(req, resp);
    }
}
