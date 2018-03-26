package by.tc.task5.listener;

import by.tc.task5.controller.Constants;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;

/**
 * Created by HP on 26.03.2018.
 */
@WebListener("applications context listener")
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("log4j.properties").getFile());
        String fullPath=file.getAbsolutePath();
        System.out.println(fullPath);
        PropertyConfigurator.configure(fullPath);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }


}
