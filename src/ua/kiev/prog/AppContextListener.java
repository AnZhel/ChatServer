package ua.kiev.prog;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by Andzhel on 02.02.2016.
 */
public class AppContextListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext cnt = servletContextEvent.getServletContext();
        String fileName = cnt.getInitParameter("LIST_OF_MEMBERS");
        File file;
        try {
            file = new File(fileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(Members.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Members members = (Members) unmarshaller.unmarshal(file);
            Members.setInstance(members);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext cnt = servletContextEvent.getServletContext();
        String fileName = cnt.getInitParameter("LIST_OF_MEMBERS");
        Members members = Members.getInstance();
        try {
            File file = new File(fileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(Members.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(members,file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
     }
}
